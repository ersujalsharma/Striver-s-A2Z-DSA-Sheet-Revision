/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{

	public static void main(String[] args) {
		int arr[] = {1,1,2,2,2,3,3};
		// As mentioned in the question we have to keep track of unique elements only.
		/*
		HashSet<Integer> hashset = new HashSet<>();
		for(int i : arr) {
			hashset.add(i);
		}
		int i=0;
		for(int el : hashset) {
			arr[i++] = el;
		}
		
		*/
		// Second Approach will be two pointer.
		int left = 0;
		int right = 1;
		while(right<arr.length){
		    if(arr[left]!=arr[right]){
		        arr[left+1] = arr[right];
		        left++;
		    }
		    right++;
		}
		while(left+1<arr.length){
		    arr[left+1] = 0;
		    left++;
		}
		for(int el : arr) System.out.print(el +" ");
	}
}
