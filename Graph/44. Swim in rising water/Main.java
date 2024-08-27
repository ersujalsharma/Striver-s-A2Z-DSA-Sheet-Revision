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
}


class Solution {
    class Triple{
        int val;
        int row;
        int col;
        public Triple(int val,int row,int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
       PriorityQueue<Triple> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        queue.add(new Triple(grid[0][0],0,0));
        Set<String> isVisited = new HashSet<>();
        while(!queue.isEmpty()) {
            Triple arr = queue.poll();
            int val = arr.val;
            int i = arr.row;
            int j = arr.col;
            if(i == grid.length-1 && j == grid.length-1) {
                return val;
            }
            if(!isVisited.contains(i+"-"+j)) {
                isVisited.add(i+"-"+j);
                if(i-1 >= 0) {
                    int newI = i-1;
                    queue.add(new Triple(Math.max(val, grid[newI][j]), newI, j));
                }
                if(j-1 >= 0) {
                    int newJ = j-1;
                    queue.add(new Triple(Math.max(val, grid[i][newJ]), i, newJ));
                }
                if(i+1 < grid.length) {
                    int newI = i+1;
                    queue.add(new Triple(Math.max(val, grid[newI][j]), newI, j));
                }
                if(j+1 < grid.length) {
                    int newJ = j+1;
                    queue.add(new Triple(Math.max(val, grid[i][newJ]), i, newJ));
                }
            }
        }
        return 0;
    }
}