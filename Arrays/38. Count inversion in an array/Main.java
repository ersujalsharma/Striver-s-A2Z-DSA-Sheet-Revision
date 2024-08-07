/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int N = 5, array[] = {5,4,3,2,1};
// 		int count = 0;
// 		for(int i=0;i<array.length;i++){
// 		    for(int j=i+1;j<array.length;j++){
// 		        if(array[i]>array[j]){
// 		            count++;
// 		        }
// 		    }
// 		}   
        int count = 0;
        count = mergeSort(array,0,array.length-1);
		System.out.print(count);
	}
	public static int mergeSort(int[] array,int start,int end){
	    if(start>=end){
	        return 0;
	    }
	    int middle = (start+end)/2;
	    int count = 0;
	    count += mergeSort(array,start,middle);
	    count += mergeSort(array,middle+1,end);
	    count += merge(array,start,middle,end);
	    return count;
	}
	public static int merge(int[] array,int start,int middle,int end){
	    int i=start;
	    int j=middle+1;
	    int count = 0;
	    int extraSpace[] = new int[end-start+1];
	    int k=0;
	    while(i<=middle && j<=end){
	        if(array[i]<=array[j]){
	            extraSpace[k] = array[i];
	            i++;
	        }
	        else{
	            extraSpace[k] = array[j];
	            j++;
	            count += middle-i+1;
	        }
	        k++;
	    }
	    while (i <= middle) {
            extraSpace[k++] = array[i++];
        }
        while (j <= end) {
            extraSpace[k++] = array[j++];
        }
	    for(int e=0;e<extraSpace.length;e++){
	        array[start+e] = extraSpace[e];
	    }
	    return count;
	}
	
}
