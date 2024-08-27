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
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int distance[] = new int[V];
        Arrays.fill(distance,(int)1e8);
        distance[S] = 0;
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> edge : edges){
                int src = edge.get(0);
                int des = edge.get(1);
                int dis = edge.get(2);
                if(distance[src]!=1e8 && distance[src]+dis < distance[des]){
                    distance[des] = distance[src]+dis;
                }
            }
        }
        for(ArrayList<Integer> edge : edges){
            int src = edge.get(0);
            int des = edge.get(1);
            int dis = edge.get(2);
            if(distance[src]!=1e8 && distance[src]+dis < distance[des]){
                return new int[]{-1};
            }
        }
        return  distance;
    }
}
