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
		Main main = new Main();
		int N = 5, K = 4;
		String dict[] = {"baa","abcd","abca","cab","cad"};
		String ans = main.findOrder(dict,N,K);
		System.out.print(ans);
	}
	public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        // if it is dictionary then the consecutive contains the order.
         ArrayList<ArrayList<Integer>> adj= new ArrayList<ArrayList<Integer>>();
        for(int x=0;x<K; x++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int x=0;x<N-1; x++)
        {
            String s1= dict[x];
            String s2= dict[x+1];
            int len= Math.min(s1.length(), s2.length());
            
            for(int y=0; y<len; y++)
            {
                if(s1.charAt(y)!= s2.charAt(y))
                {
                   
                    adj.get(s1.charAt(y) - 'a').add(s2.charAt(y) - 'a');
                    
                    break;
                }
            }
        }
            
            int ans[]= new int[K];
            ans= topoSort(K, adj);
            String s="";
            for(int x=0;x<K; x++)
            {
                s=s+ (char)('a'+ans[x]);
            }
            return s;
        
        
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited, int source)
    {
        visited[source]=true;
        
        for(int node: adj.get(source))
        {
            if(!visited[node])
            {
                dfs(adj,stack,visited,node);
                
            }
        }
        stack.push(source);
    }
    
    
    
    private int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        Stack<Integer> stack= new Stack<>();
        boolean visited[]= new boolean[V];
        for(int x=0;x<V; x++)
        {
            if(!visited[x])
                dfs(adj,stack,visited,x);
        }
        
        int arr[]= new int[V];
        for(int x=0; x<V; x++)
        {
            arr[x]=stack.pop();
        }
        return arr;
        
    }
}
