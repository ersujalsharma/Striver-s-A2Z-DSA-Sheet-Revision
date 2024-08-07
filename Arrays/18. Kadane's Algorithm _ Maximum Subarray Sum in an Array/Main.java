/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		// Brute Force -> SubArray.
		/*
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
		    int sum = 0;
		    for(int j=i;j<arr.length;j++){
		        sum += arr[j];
		        max = Math.max(sum,max);
		    }
		}
		System.out.print(max);
		*/
		int maxValue = 0;
		int sum = 0;
		for(int i=0;i<arr.length;i++){
		    sum += arr[i];
		    if(sum>maxValue){
		        maxValue = sum;
		    }
		    if(sum<=0){
		        sum = 0;
		    }
		}
		System.out.print(maxValue);
	}
}
