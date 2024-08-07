/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int arr[] = {4,3,1,5,6};
		/*
		int maxValue = 0;
		for(int i=0;i<arr.length;i++){
		    int smallest = Integer.MAX_VALUE;
		    int secondSmallest = Integer.MAX_VALUE;
		    for(int j=i;j<arr.length;j++){
		        if(arr[j]<smallest){
		            secondSmallest = smallest;
		            smallest = arr[j];
		        }
		        else if(arr[j]<secondSmallest){
		            secondSmallest = arr[j];
		        }
		    }
		    maxValue = Math.max(maxValue, smallest + secondSmallest);
		}
		System.out.print(maxValue);
		*/
		int maxValue = Integer.MIN_VALUE;
		int leftPointer = 0;
		int rightPointer = 1;
		int currentPointer = 2;
		while(currentPointer<arr.length){
		    if(arr[currentPointer]>arr[leftPointer]){
		        leftPointer = rightPointer;
		        rightPointer = currentPointer;
		    }
		    else if(arr[currentPointer]>arr[rightPointer]){
		        rightPointer = currentPointer;
		    }
		    if(arr[leftPointer]+arr[rightPointer]>maxValue){
		        maxValue = arr[leftPointer] + arr[rightPointer];
		    }
		    currentPointer++;
		}
		System.out.print(maxValue);
	}
}
