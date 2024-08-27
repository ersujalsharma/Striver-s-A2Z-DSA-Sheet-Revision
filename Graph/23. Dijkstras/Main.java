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
		// it has all pos so there is no need of visited array.
	}
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dis[] = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[S] = 0;
        Queue<Integer> pq = new ArrayDeque<>();
        pq.add(S);
        while(!pq.isEmpty()){
            int popped = pq.poll();
            for(ArrayList<Integer> node : adj.get(popped)){
                if(dis[popped]+node.get(1)<dis[node.get(0)]){
                    dis[node.get(0)] = dis[popped]+node.get(1);
                    pq.add(node.get(0));
                }
            }
        }
        return dis;
    }
}
