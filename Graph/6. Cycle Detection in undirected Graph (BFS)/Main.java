/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
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
	    boolean ans = isCycle(V,adj);
	    System.out.print(ans);
	}
	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(check(i,V,adj,vis))  return true;
            }
        }
        return false;
    }
    public static boolean check(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[src]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(int adjacentNode:adj.get(node)){
                if(vis[adjacentNode] == false){
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode,node));
                }
                
                else if(parent != adjacentNode){
                    return true;
                }
                
            }
        }
        return false;
    }
}
