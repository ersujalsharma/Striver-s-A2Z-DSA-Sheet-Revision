/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	class Pair{
        int node;
        int time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair> graph[] = new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList();
        }
        for(int i[] : times){
            graph[i[0]].add(new Pair(i[1],i[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(k,0));
        int time[] = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k] = 0;
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        int max = 0;
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            if(visited.contains(popped.node)) continue;
            visited.add(popped.node);
            count++;
            max = popped.time;
            if(count == n) break;
            for(int i=0;i<graph[popped.node].size();i++){
                Pair neighbour = graph[popped.node].get(i);
                if(popped.time+neighbour.time<time[neighbour.node]){
                    time[neighbour.node] = popped.time+neighbour.time;
                    pq.add(new Pair(neighbour.node,time[neighbour.node])); 
                }
            }
        }
        // int max = Integer.MIN_VALUE;
        // for(int i=1;i<time.length;i++){
        //     max = Math.max(max,time[i]);
        // }
        // return max == Integer.MAX_VALUE ? -1 : max;
        return count == n ? max : -1;
    }
}
