/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		// Brute Force -> New Matrix;
		/*
		int[][] newMatrix = new int[matrix.length][matrix.length];
		int newi = 0;
		int newj = 0;
		for(int j = 0;j<matrix.length;j++){
		    for(int i=matrix.length-1;i>=0;i--){
		        newMatrix[newi][newj] = matrix[i][j];
		        newj++;
		        if(newj>=matrix.length){
		            newi++;
		            newj=0;
		        }
		    }
		}
		for(int i=0;i<matrix.length;i++){
		    for(int j=0;j<matrix.length;j++){
		        System.out.print(newMatrix[i][j]+" ");
		    }
		    System.out.println();
		}
		*/
		for(int i=0;i<matrix.length;i++){
		    for(int j=0;j<i;j++){
		        int temp = matrix[i][j];
		        matrix[i][j] = matrix[j][i];
		        matrix[j][i] = temp;
		    }
		}
		for(int i=0;i<matrix.length;i++){
		    int j=0,k=matrix.length-1;
		    while(j<k){
		        int temp = matrix[i][j];
		        matrix[i][j] = matrix[i][k];
		        matrix[i][k] = temp;
		        j++;
		        k--;
		    }
		}
		for(int i=0;i<matrix.length;i++){
		    for(int j=0;j<matrix.length;j++){
		        System.out.print(matrix[i][j]+" ");
		    }
		    System.out.println();
		}
	}
}
