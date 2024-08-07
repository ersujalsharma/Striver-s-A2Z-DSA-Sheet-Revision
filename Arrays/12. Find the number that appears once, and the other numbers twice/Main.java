/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Find the number that appears once, and the other numbers twice
	public static void main(String[] args) {
		int arr[] = {4,1,2,1,2};
		// Brute Force -> HashMap for freq
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		for(int i : arr){
		    hashmap.put(i,hashmap.getOrDefault(i,0)+1);
		}
		int ans = -1;
		for(int i : hashmap.keySet()){
		    if(hashmap.get(i)==1){
		        ans = i;
		        break;
		    }
		}
		System.out.print(ans);
		System.out.println();
		// Bitwise Xor Operator.
		// why we are taking xor, just because all the number's are 
		// reapeating except one, so same will become using xor,
		// and even will be safe
		int xor = 0;
		for(int i:arr){
		    xor ^= i;
		}
		System.out.println(xor);
	}
}
