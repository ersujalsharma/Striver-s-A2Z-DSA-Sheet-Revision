/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Given an array of integers and an integer k, 
    // return the total number of subarrays whose sum equals k.
	public static void main(String[] args) {
		 int N = 4, array[] = {3, 1, 2, 4}, k = 6;
		 // Find all subarrays with k
		 /*
		 int count = 0;
		 for(int i=0;i<array.length;i++){
		     int sum = 0;
		     for(int j=i;j<array.length;j++){
		         sum+=array[j];
		         if(sum == k){
		             count++;
		         }
		         else if(sum>k){
		             break;
		         }
		     }
		 }
		 */
		 // As we can see we have to find sum with k,
		 // now find sum, if it exceed the sum shrink from left.
		 HashMap<Integer,Integer> hashmap = new HashMap<>();
            hashmap.put(0,1);
            int sum = 0;
            int count = 0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                count += hashmap.getOrDefault(sum-k,0);
                hashmap.put(sum,hashmap.getOrDefault(sum,0)+1);
            }
		 System.out.print(count);
	}
}
