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
		int arr [] = {1,1,1};
		// finding second smallest and second largest in an array.
		// it is fix if there is only one number and it is repeating the there is no second smallest or largest.
		// Brute Force 
		/*
		Arrays.sort(arr);
		// now we know the largest is the last and the second largest will be the pre occured and not matching with the largest.
		
		int largest = arr[arr.length-1];
		int smallest = arr[0];
		int secondSmallest = -1;
		int secondLargest = -1;
		for(int i=arr.length-2;i>=0;i--){
		    if(arr[i]!=largest){
		        secondLargest = arr[i];
		        break;
		    }
		}
		for(int i=1;i<arr.length;i++){
		    if(arr[i]!=smallest){
		        secondSmallest = arr[i];
		        break;
		    }
		}
		System.out.println(secondSmallest + " " + secondLargest);
		*/
		// optimized; make variables as smallest and second smallest also same for largest and second largest.
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = smallest;
		int largest = Integer.MIN_VALUE;
		int secondLargest = largest;
		// now try to find if any thing is lesser the smallest make that number is smallest and smallest is second smallest now.
		for(int i : arr){
		    if(i<smallest){
		        secondSmallest = smallest; // smallest will become the secondSmallest
		        smallest = i; // and the current number is smallest now.
		    }
		    else if(i!=smallest && i<secondSmallest){
		        secondSmallest = i; // the number will become the secondSmallest
		    }
		    if(i>largest){
		        secondLargest = largest; // largest will become the secondLargest
		        largest = i; // the number will be the largest one.
		    }
		    else if(i!=largest && i>secondLargest){
		        secondLargest = i; // the number will become the secondLargest
		    }
		}
	    if(secondSmallest == Integer.MAX_VALUE) {
	        System.out.println("Not Existed");
	        return;
	    }
			System.out.println(secondSmallest + " " + secondLargest);
	}
}
