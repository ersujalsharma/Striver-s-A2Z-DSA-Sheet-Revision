/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Given an array containing both positive and negative integers, 
    // we have to find the length of the 
    // longest subarray with the sum of all elements equal to zero.
	public static void main(String[] args) {
	    int N = 6, array[] = {9, -3, 3, -1, 6, -5};
	    HashMap<Integer,Integer> hashmap = new HashMap<>();
	    int sum = 0;
	    int max = 0;
	    hashmap.put(0,-1);
	    for(int i=0;i<array.length;i++){
	        sum += array[i];
	        if(hashmap.containsKey(sum)){
	            max = Math.max(max,i-hashmap.get(sum));
	        }
	        else{
	            hashmap.put(sum,i);
	        }
	    }
	    System.out.print(max);
	}
}
