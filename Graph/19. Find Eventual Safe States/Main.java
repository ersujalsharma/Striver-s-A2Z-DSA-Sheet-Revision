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
		int graph[][] = {{1,2},{2,3},{5},{0},{5},{},{}};
		List<Integer> list = main.eventualSafeNodes(graph);
		System.out.print(list);
	}
	public List<Integer> eventualSafeNodes(int[][] graph) {
        int outdegree[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            outdegree[i] = graph[i].length;      
        }
        ArrayList<ArrayList<Integer>> indegreeNode = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            indegreeNode.add(i,new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                indegreeNode.get(graph[i][j]).add(i);
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<outdegree.length;i++){
            if(outdegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int popped = q.poll();
            list.add(popped);
            for(int i=0;i<indegreeNode.get(popped).size();i++){
                outdegree[indegreeNode.get(popped).get(i)]--;
                if(outdegree[indegreeNode.get(popped).get(i)] == 0){
                    q.add(indegreeNode.get(popped).get(i));
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
