/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		// Problem Statement: Given an array of integers, rotating array of elements by k elements either left or right.
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int k = 5;
		// Brute Force -> Rotate Left By One space k times.
		/*
		while(k>0){
		    int temp = arr[0];
		    for(int i=1;i<arr.length;i++){
		        arr[i-1] = arr[i];
		    }
		    arr[arr.length-1] = temp;
		    k--;
		}
	    */
	    // 1 2 3 4 5, 6 7 8 9 10
	    // as we know we have to these first part to right side, we can do in other way also.
	    // first reverse both part of array.
	    // 5 4 3 2 1, 10 9 8 7 6
	    // reverse the whole array 
	    // 6 7 8 9 10 1 2 3 4 5
	    reverse(arr,0,k-1);
	    reverse(arr,k,arr.length-1);
	    reverse(arr,0,arr.length-1);
	    
	    for(int i=0;i<arr.length;i++){
	        System.out.print(arr[i]+" ");
	    }
	}
	public static void reverse(int[] arr, int left,int right){
	    while(left<right){
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	        left++;
	        right--;
	    }
	}
}
