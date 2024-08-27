/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		int ans = numEnclaves(grid);
		System.out.print(ans);
	}
	public static int numEnclaves(int[][] grid) {
        // walk from boundary and mark all one's
        for(int i=0;i<grid.length;i++){
            help(grid,i,0);
            help(grid,i,grid[0].length-1);
        }
        for(int j=0;j<grid[0].length;j++){
            help(grid,0,j);
            help(grid,grid.length-1,j);
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void help(int[][] grid,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return;
        }
        grid[row][col] = 0;
        help(grid,row,col+1);
        help(grid,row+1,col);
        help(grid,row,col-1);
        help(grid,row-1,col);
    }
}
