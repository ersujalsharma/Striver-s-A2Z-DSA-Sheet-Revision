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
		int numCourses = 2;
		int prerequisites[][] ={{1,0}};
		Main main = new Main();
		boolean ans =  main.canFinish(numCourses,prerequisites);
		System.out.print(ans);
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(i,new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int popped = q.poll();
            count++;
            for(int i=0;i<list.get(popped).size();i++){
                indegree[list.get(popped).get(i)]--;
                if(indegree[list.get(popped).get(i)] == 0){
                    q.add(list.get(popped).get(i));
                }
            }
        }
        return count == numCourses;
    }
}
