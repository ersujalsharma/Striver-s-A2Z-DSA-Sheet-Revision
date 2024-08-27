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
	static int[] dijkstraOptimized(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dis[] = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(S,0));
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            for(ArrayList<Integer> node : adj.get(popped.val)){
                if(popped.distance+node.get(1)<dis[node.get(0)]){
                    dis[node.get(0)] = popped.distance+node.get(1);
                    pq.add(new Pair(node.get(0),popped.distance+node.get(1)));
                }
            }
        }
        return dis;
    }
}
