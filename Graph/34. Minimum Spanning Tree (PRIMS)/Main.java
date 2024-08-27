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
	static class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        // Prims -> start from arbitary node. and traverse cheap one.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0,0));
        int val = 0;
        while(!pq.isEmpty()){
            Pair popped = pq.poll();
            if(visited[popped.node]) continue;
            visited[popped.node] = true;
            val += popped.distance;
            for(int[] neighbour : adj.get(popped.node)){
                if(!visited[neighbour[0]]){
                    pq.add(new Pair(neighbour[0],neighbour[1]));
                }
            }
        }
        return val;
    }
}
