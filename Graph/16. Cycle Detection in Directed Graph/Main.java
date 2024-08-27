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
		int V = 4;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<4;i++){
		    list.add(new ArrayList<>());
		}
		list.get(0).add(1);
		list.get(1).add(2);
		list.get(2).add(3);
		list.get(3).add(3);
		boolean ans = isCyclic(V,list);
		System.out.println(ans);
	}
	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        int ans = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int popped = q.poll();
            ans++;
            for(int i=0;i<adj.get(popped).size();i++){
                indegree[adj.get(popped).get(i)]--;
                if(indegree[adj.get(popped).get(i)]==0){
                    q.add(adj.get(popped).get(i));
                }
            }
        }
        // System.out.println(ans +" "+ V);
        return ans != V;
    }
}
