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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<stones.length;i++){
            if(maxRow<stones[i][0]){
                maxRow = stones[i][0];
            }
            if(maxCol<stones[i][1]){
                maxCol = stones[i][1];
            }
        }
        DSU ds = new DSU();
        ds.initialize(maxRow+maxCol+2);
        HashSet<Integer> visited = new HashSet<>();
        for(int stone[] : stones){
            ds.union(stone[0],stone[1]+maxRow+1);
            visited.add(stone[0]);
            visited.add(stone[1]+maxRow+1);
        }
        int count = 0;
        for(int i : visited){
            if(ds.findParent(i) == i){
                count++;
            }
        }
        return stones.length-count;
    }
}