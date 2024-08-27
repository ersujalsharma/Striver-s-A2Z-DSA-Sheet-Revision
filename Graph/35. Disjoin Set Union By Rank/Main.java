/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    int par[];
    int rank[];
    public void initialize(int size){
        par = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++){
            par[i] = i;
            rank[i] = 0;
        }
    }
    public int findParent(int data){
        if(par[data] == data) return data;
        return par[data] = findParent(par[data]);
    }
    public void union(int first,int second){
        int parA = findParent(first);
        int parB = findParent(second);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB] = parA; 
        }
        else{
            par[parA] = parB;
        }
    }
	public static void main(String[] args) {
		int size = 5;
		Main main = new Main();
		main.initialize(size);
		int val = main.findParent(1);
		main.union(1,2);
		int val3 = main.findParent(2);
		main.union(4,3);
		int val5 = main.findParent(3);
		int val6 = main.findParent(4);
		System.out.print(val +" "+val3+"  "+val5+" "+val6);
	}
}
