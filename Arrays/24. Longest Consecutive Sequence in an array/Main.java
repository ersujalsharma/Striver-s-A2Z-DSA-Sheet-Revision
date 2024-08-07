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
		int arr[] = {100,200,1,1,3,2,4};
		// Brute Force -> For Each Element Try their consecutive in the array,
		/*
		int max = 0;
		for(int i=0;i<arr.length;i++){
		    int element = arr[i];
		    element++; // 101
		    int count = 1;
		    while(true){
		        boolean check = false;
		        for(int el : arr){ // searching for 101,
		            if(el==element){
		                check = true;
		                break;
		            }
		        }
		        if(check){
		            element++;
		            count++;
		        }
		        else{
		            break;
		        }
		    }
		    max = Math.max(count,max);
		}
		System.out.print(max);
		*/
		// Optimized as we can see that we need consecutive one's, so what we can do is, we can sort it.
		Arrays.sort(arr);
		int count = 1;
		int max = 0;
		for(int i=1;i<arr.length;i++){
		    // for same elements in an array.
		    if(arr[i] == arr[i-1]){
		        continue;
		    }
		    
		    if(arr[i]==arr[i-1]+1){
		        count++;
		    }
		    else{
		        count = 1;
		    }
		    max = Math.max(count,max);
		}
		System.out.print(max);
	}
}
