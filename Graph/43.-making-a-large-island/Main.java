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
    public int largestIsland(int[][] grid) {
        DSU ds = new DSU();
        int n = grid.length;
        int m = grid[0].length;
        ds.initialize(n*m);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) continue;
                if(i-1>=0 && grid[i-1][j]==1){
                    ds.union(m*(i-1)+j,m*i+j);
                }
                if(j-1>=0 && grid[i][j-1]==1){
                    ds.union(m*i+(j-1),m*i+j);
                }
                System.out.println(i+"/"+j);
                // System.out.println(Arrays.toString(ds.par));
            }
        }
        // System.out.println(Arrays.toString(ds.par));
        // System.out.println(Arrays.toString(ds.size));
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int par = ds.findParent(m*i+j);
                    max = Math.max(max,ds.size[par]);
                }
                else{
                    HashSet<Integer> visited = new HashSet<>();
                    int count = 0;
                    if(i-1>=0 && grid[i-1][j]==1){
                        int par = ds.findParent(m*(i-1)+j);
                        count += ds.size[par];
                        visited.add(par);
                    }
                    if(j-1>=0 && grid[i][j-1]==1){
                        int par = ds.findParent(m*i+(j-1));
                        if(!visited.contains(par)){
                            visited.add(par);
                            count += ds.size[par];
                        }
                    }
                    if(i+1<grid.length && grid[i+1][j]==1){
                        int par = ds.findParent(m*(i+1)+j);
                        if(!visited.contains(par)){
                            visited.add(par);
                            count += ds.size[par];
                        }
                    }
                    if(j+1<grid[0].length && grid[i][j+1]==1){
                        int par = ds.findParent(m*(i)+(j+1));
                        if(!visited.contains(par)){
                            visited.add(par);
                            count += ds.size[par];
                        }
                    }
                    max = Math.max(count+1,max);
                    // System.out.println(i+"-"+j+"->"+max);
                }
            }
        }
        return max;
    }
}
class DSU {
	int par[];
    int size[];
    public void initialize(int siz){
        par = new int[siz];
        size = new int[siz];
        for(int i=0;i<siz;i++){
            par[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int data){
        if(par[data] == data) return data;
        return par[data] = findParent(par[data]);
    }
    public void union(int first,int second){
        int parA = findParent(first);
        int parB = findParent(second);
        if(parA==parB) return;
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