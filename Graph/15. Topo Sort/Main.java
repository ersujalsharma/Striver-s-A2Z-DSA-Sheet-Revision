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
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		Main main = new Main();
// 3 4
// 3 0
// 1 0
// 2 0
        int edge = 3;
        int nodes = 4;
        for(int i=0;i<nodes;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(3).add(0);
        adj.get(1).add(0);
        adj.get(2).add(0);
        
// 		int[] ans = topoSort(nodes,adj);

        int indegree[] = new int[nodes];
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ans[] = new int[nodes];
        int a = 0;
        while(!q.isEmpty()){
            int popped = q.poll();
            ans[a++] = popped;
            for(int i=0;i<adj.get(popped).size();i++){
                indegree[adj.get(popped).get(i)]--;
                if(indegree[adj.get(popped).get(i)]==0){
                    q.add(adj.get(popped).get(i));
                }
            }
        }

		for(int i : ans){
		    System.out.print(i+" ");
		}
	}
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,i,stack,visited);
            }
        }
        int arr[] = new int[V];
        int i=0;
        while(!stack.isEmpty()){
            arr[i++] = stack.pop();
        }
        return arr;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, Stack<Integer> stack,boolean visited[]){
        visited[src] = true;
        for(int i : adj.get(src)){
            if(!visited[i]){
                dfs(adj,i,stack,visited);
            }
        }
        stack.push(src);
    }
}
