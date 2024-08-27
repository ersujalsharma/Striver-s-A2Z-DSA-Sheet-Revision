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
	    Main main = new Main();
		int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1;
		int sc = 1;
		int color = 2;
		// bfs
		image = main.floodFill(image,sr,sc,color);
		// dfs
		image = main.floodFillDFS(image,sr,sc,color);
		for(int i=0;i<image.length;i++){
		    for(int j=0;j<image[i].length;j++){
		        System.out.print(image[i][j]+" ");
		    }
		    System.out.println();
		}
	}
	public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        help(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void help(int[][] image,int sr,int sc,int color,int prevColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[sr].length || image[sr][sc]!=prevColor){
            return;
        }
        image[sr][sc] = color;
        for(int i=0;i<4;i++){
            help(image,sr+row[i],sc+col[i],color,prevColor);
        }
    }
	
	class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    int row[] = {-1,0,+1,0};
    int col[] = {0,-1,0,+1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr,sc));
        int prev = image[sr][sc];
        image[sr][sc] = color;
        while(!q.isEmpty()){
            Pair popped = q.poll();
            System.out.println(popped.row+" "+popped.col);
            for(int i=0;i<4;i++){
                if(check(image,popped.row+row[i],popped.col+col[i],prev)){
                    image[popped.row+row[i]][popped.col+col[i]] = color;
                    q.add(new Pair(popped.row+row[i],popped.col+col[i]));
                }
            }
        }
        return image;
    }
    public boolean check(int[][] image,int row,int col,int prevColor){
        if(row<0 || row>=image.length || col<0 || col>=image[row].length || image[row][col]!=prevColor){
            return false;
        }
        return true;
    }
}
