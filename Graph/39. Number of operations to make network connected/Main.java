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
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // totals cables currently >= needs.
        // remove cycle they are extras.
        DSU ds = new DSU();
        ds.initialize(n);
        int extras = 0;
        for(int connection[] : connections){
            if(ds.findParent(connection[0]) == ds.findParent(connection[1])){
                extras++;
            }
            else{
                ds.union(connection[0],connection[1]);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i && ds.size[i]==0){
                count++;
            }
        }
        return extras-(count-1)>=0 ? count-1 : -1;
    }
}