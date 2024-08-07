/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Given an array of N integers. 
    // Find the elements that appear more than N/3 times in the array. 
    // If no such element exists, return an empty vector.
	public static void main(String[] args) {
		int N = 5, array[] = {1,2,2,3,2};
		// Brute Force -> Used HashMap Freq.
		/*
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		for(int i : array){
		    hashmap.put(i,hashmap.getOrDefault(i,0)+1);
		}
		List<Integer> list = new ArrayList<>();
		for(int i : hashmap.keySet()){
		    if(hashmap.get(i)>array.length/3){
		        list.add(i);
		    }
		}
		System.out.print(list);
		*/
		// N/3 means there can be 2 maximums,
		int el1 = Integer.MIN_VALUE, count1 = 0;
		int el2 = Integer.MIN_VALUE, count2 = 0;
		for(int i : nums){
		    if(count1==0 && i!=el2){
		        el1 = i;
		        count1 = 1;
		    }
		    else if(count2==0 && i!=el1){
		        el2 = i;
		        count2 = 1;
		    }
		    else if(el1 == i){
		        count1++;
		    }
		    else if(el2 == i){
		        count2++;
		    }
		    else{
		        count1--;
		        count2--;
		    }
		}
		// check both elements did apprear more than n/3;
        List<Integer> list = new ArrayList<>();
		int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        int mini = (int)(nums.length / 3) + 1;
        if (cnt1 >= mini) list.add(el1);
        if (cnt2 >= mini) list.add(el2);
        return list;
	}
}
