/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
class Triple{
    int row;
    int col;
    int dis;
    public Triple(int row, int col,int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
public class Main
{
	public static void main(String[] args) {
	    int mat[][] = {{0,0,0},{0,1,0},{1,1,1}};
// 		for(int i=0;i<mat.length;i++){
//             for(int j=0;j<mat[0].length;j++){
//                 if(mat[i][j]==1)
//                     mat[i][j] = help(mat,i,j);
//                 System.out.print(mat[i][j]+" ");
//             }
//             System.out.println();
//         }
    // Optimized first stored all zero and tried to cover all ones.
    Queue<Triple> q = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;
        int dis[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Triple(i,j,0));
                    mat[i][j] = 2;
                }
            }
        }
        int row[] = {-1,0,+1,0};
        int col[] = {0,-1,0,+1};
        while(!q.isEmpty()){
            Triple p = q.poll();
            int first = p.row;
            int last = p.col;
            int steps = p.dis;
            dis[first][last] = steps;
            for(int i=0;i<4;i++){
                if(first+row[i]<m && first+row[i]>=0 
                    && last+col[i]<n && last+col[i]>=0
                    && mat[first+row[i]][last+col[i]]==1
                ){
                    mat[first+row[i]][last+col[i]] = 0;
                    q.add(new Triple(first+row[i],last+col[i],steps+1));
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[0].length;j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
	}
    
    public static int rows[] = {-1,0,+1,0};
    public static int cols[] = {0,-1,0,+1};
    public static int help(int[][] mat,int row,int col){
        Queue<Triple> q = new ArrayDeque<>();
        q.add(new Triple(row,col,0));
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                Triple popped = q.poll();
                for(int index = 0;index<4;index++){
                    if(check(mat,popped.row+rows[index],popped.col+cols[index])){
                        if(mat[popped.row+rows[index]][popped.col+cols[index]]==1){
                            q.add(new Triple(popped.row+rows[index],popped.col+cols[index],popped.dis+1));
                        }
                        else if(mat[popped.row+rows[index]][popped.col+cols[index]]==0){
                            return popped.dis+1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static boolean check(int[][] mat,int row,int col){
        if(row<0 || row>=mat.length || col<0 || col>=mat[0].length){
            return false;
        }
        return true;
    }
}
