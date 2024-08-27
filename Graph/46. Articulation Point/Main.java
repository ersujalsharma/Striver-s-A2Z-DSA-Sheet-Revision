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

class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int vis[] = new int[V];
        int tin[] = new int[V];
        int low[] = new int[V];
        int mark[] = new int[V];
        
        for(int i = 0 ; i<V ; i++){
            if(vis[i] == 0){
                dfs(i , -1 , vis , tin , low , mark , adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i<V ; i++){
            if(mark[i] == 1) {
                ans.add(i);
            }
        }
        
        if(ans.size() == 0) {
            ans.add(-1);
        }
        
        return ans;
    }
    private int timer = 0;
    
    public void dfs(int node , int parent , int vis[] , int tin[] , int low[] , int mark[] ,
    ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        
        int child = 0 ;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            
            if(vis[it] == 0){
                dfs(it , node , vis , tin , low , mark , adj);
                low[node] = Math.min(low[node] , low[it]);
                
                //check for Articulation Point
                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node] , tin[it]);
            }
        }
        
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
}