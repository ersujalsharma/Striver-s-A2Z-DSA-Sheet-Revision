/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
    public int getKey(){
        return row;
    }
    public int getValue(){
        return col;
    }
}
public class Main
{
	public static void main(String[] args) {
	    int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		int max = 0;
		// Here the main trick is that, we store all the rotten oranges at a time and then traverse their near one.
		
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        max = help(grid,q);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(max);
    }
    public static int help(int[][] grid,Queue<Pair> q){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean fresh = false;
            for(int k=0;k<size;k++){
                Pair p = q.poll();
                int xaxis = p.getKey();
                int yaxis = p.getValue();
                if(xaxis+1<n && grid[xaxis+1][yaxis]==1){
                    grid[xaxis+1][yaxis] = 2;
                    q.add(new Pair(xaxis+1,yaxis));
                    fresh = true;
                }
                if(xaxis-1>=0 && grid[xaxis-1][yaxis]==1){
                    grid[xaxis-1][yaxis] = 2;
                    q.add(new Pair(xaxis-1,yaxis));
                    fresh = true;
                }
                if(yaxis+1<m && grid[xaxis][yaxis+1]==1){
                    grid[xaxis][yaxis+1] = 2;
                    q.add(new Pair(xaxis,yaxis+1));
                    fresh = true;
                }
                if(yaxis-1>=0 && grid[xaxis][yaxis-1]==1){
                    grid[xaxis][yaxis-1] = 2;
                    q.add(new Pair(xaxis,yaxis-1));
                    fresh = true;
                }
            }
            if(fresh == true){
                count++;
            }
        }
        return count;
    }
}
