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
	    adj.add(2,new ArrayList(Arrays.asList(new Integer[]{4})));
	    adj.add(3,new ArrayList(Arrays.asList(new Integer[]{})));
	    adj.add(4,new ArrayList(Arrays.asList(new Integer[]{})));
	    for(int i=0;i<V;i++){
	        System.out.println(adj.get(i));
	    }
		ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[V];
        visited[0] = true;
        while(!q.isEmpty()){
            int popped = q.poll();
            list.add(popped);
            for(int neighbour : adj.get(popped)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        System.out.print(list);
	}
}
