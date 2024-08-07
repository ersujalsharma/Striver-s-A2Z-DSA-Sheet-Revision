/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Move Zeros to end
    // 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
	public static void main(String[] args) {
		int arr[] = {1,0,2,3,0,4,0,1};
		// Brute Force -> take an extra array, and put all non zero in the new array,
		/*
		int i=0;
		int ans[] = new int[arr.length];
		for(int el : arr){
		    if(el!=0){
		        ans[i++] = el;
		    }
		}
		for(int el : ans){
		    System.out.print(el+" ");
		}
		*/
		// Optimized -> Using Two Pointers, 
		int right = arr.length-1;
		int left = arr.length-1;
		while(left>=0){
		    if(arr[left]!=0){
		        left--;
		    }
		    else{
		        int temp = arr[left];
		        arr[left] = arr[right];
		        arr[right] = temp;
		        right--;
		    }
		}
		for(int el : arr){
		    System.out.print(el+" ");
		}
	}
}
