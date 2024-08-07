/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
    // Set Matrix Zero.
	public static void main(String[] args) {
        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};	
        /*
        int newMatrix[][] = new int[matrix.length][matrix[0].length];
        for(int i[] : newMatrix) Arrays.fill(i,1);
        // Brute Force -> Search the 0 in the matrix and replace all its row and column with 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    // make  current row to zero
                    for(int k=0;k<matrix[0].length;k++){
                        newMatrix[i][k] = 0;
                    }
                    // make current col to zero;
                    for(int k=0;k<matrix.length;k++){
                        newMatrix[k][j] = 0; 
                    }
                }
            }
        }
        */
        // Optimization -> is just remove the extra space complexity and remember the rows and column which has zero.
        boolean row[] = new boolean[matrix.length];
        boolean col[] = new boolean[matrix[0].length];
        // now traverse the matrix and mark the rows.
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
	}
}
