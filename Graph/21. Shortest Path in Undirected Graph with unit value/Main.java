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
        int val;
        int distance;
        public Pair(int val,int distance){
            this.val = val;
            this.distance = distance;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int dis[] = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(src,0));
        boolean visited[] = new boolean[n];
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            visited[popped.val] = true;
            for(int i=0;i<graph[popped.val].size();i++){
                int neighbour = graph[popped.val].get(i);
                if(visited[neighbour]) continue;
                if(popped.distance+1<dis[neighbour]){
                    dis[neighbour] = popped.distance+1;
                }
                pq.add(new Pair(neighbour,dis[neighbour]));
            }
        }
        for(int i=0;i<dis.length;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i] = -1;
            } 
        }
        return dis;
    }
}
