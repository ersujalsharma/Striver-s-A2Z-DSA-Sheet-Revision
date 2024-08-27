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
}

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n]; // visited 
        int tin[] = new int[n]; // time of insertion
        int low[] = new int[n]; // low time of insertion
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }
    int timer = 1;
    public void dfs(int node, int parent,int[] vis,ArrayList<ArrayList<Integer>> adj,int tin[],int[] low, List<List<Integer>> bridges){
        vis[node] = 1; // visited the node.
        tin[node] = low[node] = timer; // first time of insersion and low time of insertion will be the same as timer,
        timer++;
        for(int it : adj.get(node)){
            if(it == parent) continue; // all adjacent except parent.
            if(vis[it]==0){ // not visited one.
                dfs(it,node,vis,adj,tin,low,bridges);
                // after traversal calculate low and also check can neighbour will be reached without current.
                low[node] = Math.min(low[node],low[it]); 
                if(low[it]>tin[node]){ // low of neighbour should be lesser or equal to the time of insertion of current.
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node] = Math.min(low[node],low[it]); // if visited then we will just update our lowewst time of insertion for current node.
            }
        }
    }
}