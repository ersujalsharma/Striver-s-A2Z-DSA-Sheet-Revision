/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // 3-Sum Problem
    // 3 Sum : Find triplets that add up to a zero
	public static void main(String[] args) {
	    int[] nums = {-1,0,1,2,-1,-4};
	    
		// Three Variables with Three Loops
		/*
		HashSet<ArrayList<Integer>> list = new HashSet<>();
		for(int i=0;i<nums.length;i++){
		    // to optimize the same -> we have to sort the array.
		    for(int j=i+1;j<nums.length;j++){
		        for(int k=j+1;k<nums.length;k++){
		            if(nums[i]+nums[j]+nums[k]==0){
		                ArrayList<Integer> inner = new ArrayList<>();
		                inner.add(nums[i]);
		                inner.add(nums[j]);
		                inner.add(nums[k]);
		                Collections.sort(inner);
		                list.add(inner);
		            }
		        }
		    }
		}
		*/
		// Optimization -> to find the target sum, we can use Two Pointers, 
		// For the third pointer, i'll use outer for loop.
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> list = new HashSet<>();
		int sum = 0;
		for(int i=0;i<nums.length;i++){
		    // first found ->
		    // now i'll tackle to find the rest two sum.
		    int j=i+1,k=nums.length-1;
		    while(j<k){
		        if(nums[i]+nums[j]+nums[k]<sum){
		            j++;
		        }
		        else if(nums[i]+nums[j]+nums[k]>sum){
		            k--;
		        }
		        else{
		            ArrayList<Integer> inner = new ArrayList<>();
		            inner.add(nums[i]);
		            inner.add(nums[j]);
		            inner.add(nums[k]);
		            list.add(inner);
		            j++;
		        }
		    }
		}
	    System.out.print(list); 
	}
}
