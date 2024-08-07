/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Given two sorted arrays arr1[] and arr2[] of sizes n and m 
    // in non-decreasing order. Merge them in sorted order. 
    // Modify arr1 so that it contains the first N elements and modify arr2 
    // so that it contains the last M elements.
	public static void main(String[] args) {
		int n = 4, arr1[] = {1,4,8,10}, m = 5, arr2[] = {2,3,9};
		int i=0,j=0;
		while(i<arr1.length){
		    if(arr1[i]>arr2[0]){
		        int number = arr1[i];
		        arr1[i] = arr2[0];
		        int k=1;
		        while(k<arr2.length && arr2[k]<number){
		            arr2[k-1] = arr2[k];
		            k++;
		        } 
		        arr2[k-1] = number;
		    }
		    i++;
		}
		for(int p : arr1){
		    System.out.print(p+" ");
		}
		for(int p : arr2){
		    System.out.print(p+" ");
		}
	}
}
