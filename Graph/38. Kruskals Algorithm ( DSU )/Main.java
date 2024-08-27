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
		System.out.println("Hello World");
	}
}
class Solution {
    static class Triple{
        int src;
        int des;
        int distance;
        public Triple(int src, int des,int distance){
            this.src = src;
            this.des = des;
            this.distance = distance;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        // Prims -> start from arbitary node. and traverse cheap one.
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                pq.add(new Triple(i,adj.get(i).get(j)[0],adj.get(i).get(j)[1]));
            }
        }
        DSU ds = new DSU();
        ds.initialize(V);
        int ans = 0;
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            if(ds.findParent(t.src) != ds.findParent(t.des)){
                ds.union(t.src,t.des);
                ans += t.distance;
            }
        }
        return ans;
    }
}
class DSU
{
	int par[];
    int size[];
    public void initialize(int siz){
        par = new int[siz];
        size = new int[siz];
        for(int i=0;i<siz;i++){
            par[i] = i;
            size[i] = 0;
        }
    }
    public int findParent(int data){
        if(par[data] == data) return data;
        return par[data] = findParent(par[data]);
    }
    public void union(int first,int second){
        int parA = findParent(first);
        int parB = findParent(second);
        if(size[parA]>=size[parB]){
            par[parB] = parA; 
            size[parA] += size[parB];
        }
        else{
            par[parA] = parB;
            size[parB] += size[parA];
        }
    }
}