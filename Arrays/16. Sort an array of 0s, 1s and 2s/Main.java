/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Sort an array of 0s, 1s and 2s
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0,0};
		// Brute Force -> count 0,1,2 and place it to array.
		/*
		int count0 = 0,count1 = 0,count2 = 0;
		for(int i:nums){
		    if(i==0) count0++;
		    else if(i==1) count1++;
		    else count2++;
		}
		for(int i=0;i<nums.length;i++){
		    if(count0>0){
		        nums[i] = 0;
		        count0--;
		    }
		    else if(count1>0){
		        nums[i] = 1;
		        count1--;
		    }
		    else{ 
		        nums[i] = 2;
		        count2--;
		    }
		}
		for(int i : nums) System.out.print(i+" ");
		*/
		// Sort int i,j,k -> place 0 in starting, and 2 in the end.
		int i=0,j=0,k=nums.length-1;
		while(j<k){
		    if(nums[j]==0){
		        int temp = nums[i];
		        nums[i] = nums[j];
		        nums[j] = temp;
		        i++;
		        j++;
		    }
		    else if(nums[j]==2){
		        int temp = nums[i];
		        nums[i] = nums[k];
		        nums[k] = temp;
		        k--;
		    }
		    else{
		        j++;
		    }
		}
		for(int el : nums){
		    System.out.print(el+" ");
		}
	}
}
