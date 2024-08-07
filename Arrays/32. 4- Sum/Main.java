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
		// FourSum -> 
		int arr[] = {1,0,-1,-1,0,-2,2}, target = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
		    if(i>0 && arr[i-1]==arr[i]) continue;
		    for(int j=i+1;j<arr.length;j++){
		        if(j>i && arr[j-1]==arr[j]) continue;
		        int k = j+1, l = arr.length-1;
		        while(k<l){
    		        int sum = arr[i]+arr[j]+arr[k]+arr[l];
    		        if(sum == 0){
    		            ArrayList<Integer> inner = new ArrayList<>();
    		            inner.add(arr[i]);
    		            inner.add(arr[j]);
    		            inner.add(arr[k]);
    		            inner.add(arr[l]);
    		            list.add(inner);
    		            k++;
    		        }
    		        else if(sum<0){
    		            k++;
    		        }
    		        else{
    		            l--;
    		        }
		        }
		    }
		}
		System.out.print(list);
	}
}
