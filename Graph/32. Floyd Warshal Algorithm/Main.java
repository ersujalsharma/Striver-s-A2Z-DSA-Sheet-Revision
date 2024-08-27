/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	public void shortest_distance(int[][] matrix)
    {
        // Code here 
        for(int k=0;k<matrix.length;k++){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if(matrix[i][k]!=-1 && matrix[k][j]!=-1){
                        if(matrix[i][j]==-1 || matrix[i][k]+matrix[k][j]<matrix[i][j])
                            matrix[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
    }
}
