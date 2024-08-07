/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    //  Given an array of integers A and an integer B. Find the 
    // total number of subarrays having bitwise XOR of all elements equal to k.
	public static void main(String[] args) {
		int  A[] = {4, 2, 2, 6, 4} , k = 6;
		// Brute Force -> Find all the subarray and count the xor with K.
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		hashmap.put(0,1);
		int xor = 0;
		int count  = 0;
		for(int i : A){
		    xor ^= i;
		    if(hashmap.containsKey(xor^k)){
		        count += hashmap.get(xor^k);
		    }
		    hashmap.put(xor,hashmap.getOrDefault(xor,0)+1);
		}
		System.out.print(count);
	}
}
