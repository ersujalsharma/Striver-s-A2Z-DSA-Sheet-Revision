/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Linear Search - we have to check in the loop one by one.
	public static void main(String[] args) {
		 int arr[]={1,2,3,4,5};
		 int val = 3;
		 boolean checkVal = check(arr,val);
		 System.out.print(checkVal);
	}
	public static boolean check(int []arr, int val){
	    for(int i: arr){
	        if(i==val){
	            return true;
	        }
	    }
	    return false;
	}
}
