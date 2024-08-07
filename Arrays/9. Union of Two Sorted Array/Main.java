/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // 9. Find the Union of Two Sorted Arrays.
	public static void main(String[] args) {
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {2,3,4,4,5};
		// Brute Force -> Use HashSet
		/*
		Set<Integer> set = new TreeSet<>();
		for(int i : arr1) set.add(i);
		for(int i : arr2) set.add(i);
		for(int i: set) System.out.print(i+" ");
		*/
		// Optimized -> Two Pointer.
		ArrayList<Integer> list = new ArrayList<>();
		int pointer1 = 0;
		int pointer2 = 0;
		while(pointer1<arr1.length && pointer2<arr2.length){
		    if(arr1[pointer1]<=arr2[pointer2]){
		        if(list.isEmpty() || list.get(list.size()-1)!=arr1[pointer1]){
		            list.add(arr1[pointer1]);
		        }
		        pointer1++;
		    }
		    else{
		        if(list.isEmpty() || list.get(list.size()-1)!=arr2[pointer2]){
		            list.add(arr2[pointer2]);
		        }
		        pointer2++;
		    }
		}
		while(pointer1<arr1.length){
		    if(list.isEmpty() || list.get(list.size()-1)!=arr1[pointer1]){
		        list.add(arr1[pointer1]);
		    }
		    pointer1++;
		}
		while(pointer2<arr2.length){
		    if(list.isEmpty() || list.get(list.size()-1)!=arr2[pointer2]){
		        list.add(arr2[pointer2]);
		    }
		    pointer2++;
		}
		for(int i : list){
		    System.out.print(i+" ");
		}
	}
}
