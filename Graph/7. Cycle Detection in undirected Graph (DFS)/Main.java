/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	
	public static void main(String[] args) {
		int V = 5;
	    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(i,new ArrayList<>());
	    }
	    adj.add(0,new ArrayList(Arrays.asList(new Integer[]{1,2,3})));
	    adj.add(1,new ArrayList(Arrays.asList(new Integer[]{})));
	    adj.add(2,new ArrayList(Arrays.asList(new Integer[]{4,0,3})));
	    adj.add(3,new ArrayList(Arrays.asList(new Integer[]{0})));
	    adj.add(4,new ArrayList(Arrays.asList(new Integer[]{})));
	    boolean ans = isCycleDFS(V,adj);
	    System.out.print(ans);
	}
	
	public static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(check(adj,i,-1,vis))  return true;
            }
        }
        return false;
    }
    public static boolean check(ArrayList<ArrayList<Integer>> adj,int src,int par,boolean visited[]){
        visited[src] = true;
        for(int i : adj.get(src)){
            if(!visited[i]){
                if(check(adj,i,src,visited)){
                    return true;
                }
            }
            else if(i!=par){
                return true;
            }
        }
        return false;
    }
}
