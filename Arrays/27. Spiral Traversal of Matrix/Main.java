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
		int matrix[][] = { { 1, 2, 3, 4},
		      { 5, 6, 7, 8 },
		      { 9, 10, 11, 12} };
	   ArrayList<Integer> list = new ArrayList<>();
	    int start_row = 0;
	    int start_col = 0;
	    int end_row = matrix.length-1;
	    int end_col = matrix[0].length-1;
	    while(start_row<=end_row && start_col<=end_col){
	        // from left to right
	        for(int j=start_col;j<=end_col;j++){
	            list.add(matrix[start_row][j]);
	        }
	        start_row++;
	        if(start_row>end_row) break;
	        for(int i=start_row;i<=end_row;i++){
	            list.add(matrix[i][end_col]);
	        }
	        end_col--;
	        if(end_col<start_col) break;
	        for(int j=end_col;j>=start_col;j--){
	            list.add(matrix[end_row][j]);
	        }
	        end_row--;
	        for(int i=end_row;i>=start_row;i--){
	            list.add(matrix[i][start_col]);
	        }
	        start_col++;
	    }
	    System.out.print(list);
	}
}
