/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Two Sum : Check if a pair with given sum exists in Array
	public static void main(String[] args) {
		int N = 5, arr[] = {2,6,5,8,11}, target = 14;
		// BruteForce -> Used Two Loops for two integers
// 		boolean canTarget = checkTwoSum(arr,target);
        // we can optimize it using hashset and find the target-current element.
// 		boolean canTarget = checkTwoSumUsingHashMap(arr,target);
        // Optimized Using Two Pointers
        boolean canTarget = checkTwoSumUsingTwoPointers(arr,target);
        System.out.print(canTarget);
	}
	public static boolean checkTwoSumUsingTwoPointers(int[] arr,int target){
	    // First Sort the Array.
	    Arrays.sort(arr);
	    int left = 0;
	    int right = arr.length-1;
	    while(left<right){
	        if(arr[left]+arr[right] == target){
	            return true;
	        }
	        else if(arr[left]+arr[right]<target){
	            left++;
	        }
	        else{
	            right--;
	        }
	    }
	    return false;
	}
	public static boolean checkTwoSumUsingHashMap(int[] arr,int target){
	    // first + second = target => to find second we can target-first.
	    HashSet<Integer> hashset = new HashSet<>();
	    for(int i : arr){
	        if(hashset.contains(target-i)){
	            return true;
	        }
	        hashset.add(i);
	    }
	    return false;
	}
	public static boolean checkTwoSum(int[] arr,int target){
	    for(int i=0;i<arr.length;i++){
		    for(int j=i+1;j<arr.length;j++){
		        if(arr[i]+arr[j]==target){
		            return true;
		        }
		    }
		}
		return false;
	}
}
