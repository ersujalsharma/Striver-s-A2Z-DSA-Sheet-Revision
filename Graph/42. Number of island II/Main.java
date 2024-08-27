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
    static int row[] = {0,-1,0,+1};
    static int col[] = {-1,0,+1,0};
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        // m*i => m*i +j
        // 0 1 2 3 4 
        // 5*0 => <5*(i+1)
        // 5*1 => <5*(i+1);
        // m*row + col
        DSU ds = new DSU();
        ds.initialize(n*m);
        HashSet<Integer> visited = new HashSet<>();
        int ans[] = new int[q.length];
        int i=0;
        for(int query[] : q){
            visited.add(m*query[0]+query[1]);
            for(int r=0;r<row.length;r++){
                if(query[0]+row[r]>=0 && query[0]+row[r]<n && query[1]+col[r]>=0 && query[1]+col[r]<m
                    && visited.contains(m*(query[0]+row[r])+(query[1]+col[r]))
                ){
                    ds.union(m*(query[0]+row[r])+(query[1]+col[r]),m*query[0]+query[1]);
                    // System.out.println(m*query[0]+query[1]+" ||| "+(m*(query[0]+row[r])+(query[1]+col[r])));
                }
            }
            int count = 0;
            for(int el : visited){
                if(ds.findParent(el)==el){
                    count++;
                }
            }
            ans[i] = count;
            i++;
            // System.out.println("-"+visited);
            // System.out.println(Arrays.toString(ds.par));
        }
        // System.out.println("--->");
        return ans;
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