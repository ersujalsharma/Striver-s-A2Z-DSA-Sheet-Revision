/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Given an array of intervals, merge all the overlapping 
    // intervals and return an array of non-overlapping intervals.
	public static void main(String[] args) {
		 int intervals[][]={{1,3},{2,6},{8,10},{15,18}};
		 Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		 ArrayList<int[]> list = new ArrayList<>();
		 int i = 0;
		 while(i<intervals.length){
		     if(list.isEmpty()){
		         list.add(intervals[i]);
		     }
		     else if(list.get(list.size()-1)[1]>=intervals[i][0]){
		         list.get(list.size()-1)[0] = Math.min(list.get(list.size()-1)[0],intervals[i][0]);
		         list.get(list.size()-1)[1] = intervals[i][1];
		     }
		     else{
		         list.add(intervals[i]);
		     }
		     i++;
		 }
		 for(int l[] : list){
		     System.out.print(l[0]+" "+l[1]+"--");
		 }
// 		 System.out.print(list);
	}
}
