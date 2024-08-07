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
		// Find Largest number in an Array
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = scanner.nextInt();
		}
		//  Brute Force -> Sorting and retrieving the last element.
// 		Arrays.sort(arr);
// 		System.out.print(arr[arr.length-1]); 
		// Optimized ( Basic idea) Comparision
		int max = Integer.MIN_VALUE;
		for(int i: arr){
		    max = Math.max(i,max);
		}
		System.out.print(max);
	}
}
