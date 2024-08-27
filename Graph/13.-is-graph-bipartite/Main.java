/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
// 		int [][]graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int [][]graph = {{1,3},{0,2},{1,3},{0,2}};
		boolean ans = isBipartite(graph);
		System.out.print(ans);
	}
	public static boolean isBipartite(int[][] graph) {
        for(int i=0;i<graph.length;i++){
            if(help(graph,i,-1,1,new int[graph.length+1])){
                return false;
            }
        }
        return true;
    }
    public static boolean help(int[][] graph,int src,int par,int color,int visited[]){
        visited[src+1] = color;
        for(int i : graph[src]){
            if(visited[i+1]==0){
                if(help(graph,i,src,color == 1 ?2 : 1,visited)){
                    return true;
                }
            }
            else{
                if(i!=par && color==visited[i+1]){
                    return true;
                }
            }
        }
        return false;
    }
}
