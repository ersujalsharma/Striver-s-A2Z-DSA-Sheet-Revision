/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	// 22 Find Next Permutation.
	static void RightRotate(int arr[], int i, int j) {
            int temp = arr[j];
            for (int k = j; k > i; k--) {
                arr[k] = arr[k - 1];
            }
            arr[i] = temp;
        }
     
        // Function to Left rotate the segement
        // arr[i....j] of arr
        static void LeftRotate(int arr[], int i, int j) {
            int temp = arr[i];
            for (int k = i; k < j; k++) {
                arr[k] = arr[k + 1];
            }
            arr[j] = temp;
        }
     
        static void PrintPermutations(int arr[], int i, int n) {
     
            // Base case if i reaches end of the
            // array and there is no element
            // to swap with
            if (i == n - 1) {
                for (int k = 0; k < n; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
                return;
            }
     
            // If do not rotate any segement
            // starting from i+1th index
            PrintPermutations(arr, i + 1, n);
     
            // If we rotate segement then we can have
            // rotation of segement arr[i....j]
            for (int j = i + 1; j < n; j++) {
                RightRotate(arr, i, j);
                PrintPermutations(arr, i + 1, n);
                LeftRotate(arr, i, j);
            }
        }
	public static void main(String[] args) {
		// Brute Force -> Find all the Permutations, and return then next one.
		int arr[] = {3,1,2};
		// start brute force ->
		int copyArr[] = Arrays.copyOf(arr,arr.length);
		Arrays.sort(copyArr);
		List<int[]> list = new ArrayList<>();
		generateAllPermutations(copyArr,0,list);
		for(int[] a: list) {
			for(int i: a) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		for(int i=0; i<list.size(); i++) {
			boolean match = true;
			for(int j=0; j<list.get(i).length; j++) {
				if(list.get(i)[j]!=arr[j]) {
					match = false;
					break;
				}
			}
			if(match== true) {
				int ans[] = list.get((i+1)%list.size());
				for(int a : ans) {
					System.out.print(a+" ");
				}
				break;
			}
		}
		// it won't give the correct answer,
		int N = arr.length;
        Arrays.sort(arr);
 
        // Function Call
        System.out.println("Permutations are below");
        PrintPermutations(arr, 0, N);
		// Optimized -> Check from last and find the pair.
		/*
		int i = arr.length-2;
		while(i>=0){
		    if(arr[i]<arr[i+1]){
		        break;
		    }
		    i--;
		}
		int j= arr.length-1;
		if(i!=-1){
		    while(j>=0 && arr[j]<=arr[i]){
		        j--;
		    }
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
		reverse(arr,i+1,arr.length-1);
		for(int a : arr){
		    System.out.print(a+" ");
		}
		*/
	}
	public static void generateAllPermutations(int[] arr,int index,List<int[]> list) {
		if(index == arr.length-1) {
			list.add(Arrays.copyOf(arr,arr.length));
			return;
		}
		for(int i=index; i<arr.length; i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			generateAllPermutations(arr,index+1,list);
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}
	public static void reverse(int[] arr, int i,int j) {
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
