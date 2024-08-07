/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int row = 7,col = 4;
		// variation 1. 
		long ans = generateRow(row-1,col-1);
		System.out.println(ans);
		System.out.println();
		// variation 2.
		for(int j=1;j<=row;j++){
		    System.out.print(generateRow(row-1,j-1)+" ");
		}
		System.out.println();
		System.out.println();
		// variation 3.
		for(int i=1;i<=row;i++){
		    for(int j=1;j<=i;j++){
		        System.out.print(generateRow(i-1,j-1)+" ");
		    }
		    System.out.println();
		}
// 		System.out.print(ans);
	}
	public static long generateRow(int row,int col){
	    // n!/((r!)*(n-r)!)
	    // n to n-(r-1) (row-col)
	    // 1 to (r-1) col will be from 0 to col-1
	    long res = 1;
	    for(int i=0;i<col;i++){
	        res = res * (row-i);
	        res = res / (1+i);
	    }
	    return res;
	}
}
