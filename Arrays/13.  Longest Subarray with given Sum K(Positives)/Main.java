/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Longest Subarray with given Sum K(Positives)
    //Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
	public static void main(String[] args) {
// 		int N = 5, k = 10, array[] = {2,3,5,1,9};
		int N = 3, k = 5, array[] = {2,3,5};
		// Brute Force -> find the sum for all subarrays if it matches find the maxSubLength
		int maxSubLength = 0;
		/*
		for(int i=0;i<array.length;i++){
		    int sum = 0;
		    for(int j=i;j<array.length;j++){
		        sum+=array[j];
		        if(sum == k){
		            maxSubLength = Math.max(j-i+1,maxSubLength);
		        }
		        else if(sum>k){
		            break;
		        }
		    }
		}
		*/
		int i=0,j=0;
		while(j<array.length){
		    if(array[j]<=k){
		        k-=array[j];
		        j++;
		    }
		    else{
		        k+=array[i];
		        i++;
		    }
		    if(k==0){
		        maxSubLength = Math.max(maxSubLength,j-i);
		    }
		}
		System.out.print(maxSubLength);
	}
}
