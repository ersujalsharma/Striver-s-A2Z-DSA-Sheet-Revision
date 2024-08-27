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
		// used dfs cause it don't have cycles.
	}
	public int[] shortestPath(int N,int M, int[][] edges) {
        int minWeight[] = new int[N];
	    Arrays.fill(minWeight,Integer.MAX_VALUE);
		minWeight[0] = 0;
		dfs(edges,0,minWeight);
		for(int i=0;i<minWeight.length;i++){
		    if(minWeight[i]==Integer.MAX_VALUE)
		        minWeight[i]= -1;
		}
		return minWeight;
	}
	public void dfs(int[][] edges,int src,int[] minWeight){
	    for(int i=0;i<edges.length;i++){
	        if(edges[i][0]==src){
	            if(minWeight[edges[i][0]]+edges[i][2]<minWeight[edges[i][1]]){
    	            minWeight[edges[i][1]] = minWeight[edges[i][0]]+edges[i][2];
    	            dfs(edges,edges[i][1],minWeight);
	            }
	        }
	    }
	}
}
