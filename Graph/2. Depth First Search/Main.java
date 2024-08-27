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
	    }ArrayList<Integer> list = new ArrayList<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                help(adj,i,list,visited);
        }
        System.out.print(list);
    }
    public static void help(ArrayList<ArrayList<Integer>> adj,int index,ArrayList<Integer> list,boolean[] visited){
        list.add(index);
        visited[index] = true;
        for(int i=0;i<adj.get(index).size();i++){
            if(!visited[adj.get(index).get(i)]){
                help(adj,adj.get(index).get(i),list,visited);
            }
        }
    }
}
