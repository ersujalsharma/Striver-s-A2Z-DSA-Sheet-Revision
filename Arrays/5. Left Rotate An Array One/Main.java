/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		// Left Rotate an array by one place
		int arr[] = {1,2,3,4,5,6,7,8};
		// Brute Force.
		int ans[] = new int[arr.length];
		for(int i=1;i<arr.length;i++){
		    ans[i-1] = arr[i];
		}
		ans[arr.length-1] = arr[0];
		for(int i : ans){
		    System.out.print(i+" ");
		}
		System.out.println();
		//  Optimized -> store first element in a variable and slide the whole array with 1 index left.
		int temp = arr[0];
		for(int i=1;i<arr.length;i++){
		    arr[i-1] = arr[i];
		}
		arr[arr.length-1] = temp;
		for(int i : arr){
		    System.out.print(i+" ");
		}
		
	}
}
