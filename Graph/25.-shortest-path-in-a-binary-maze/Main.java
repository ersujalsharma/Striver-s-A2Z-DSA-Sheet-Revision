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
	class Triple{
        int row;
        int col;
        int distance;
        public Triple(int row,int col,int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==0 && grid.length==1) return 1;
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return -1;
        int distance[][] = new int[grid.length][grid.length];
        for(int i[] : distance) Arrays.fill(i,Integer.MAX_VALUE);
        distance[0][0] = 1;
        Queue<Triple> q = new ArrayDeque<>();
        q.add(new Triple(0,0,1));
        while(!q.isEmpty()){
            Triple popped = q.poll();
            for(int i=-1;i<=+1;i++){
                for(int j=-1;j<=+1;j++){
                    if(popped.row+i < 0 || popped.row+i>=grid.length || popped.col+j<0 || popped.col+j>=grid.length  || popped.distance+1>= distance[popped.row+i][popped.col+j] || grid[popped.row+i][popped.col+j] == 1) continue;
                    if(popped.row+i == grid.length-1 && popped.col+j==grid.length-1){
                        return popped.distance+1;
                    }
                    q.add(new Triple(popped.row+i,popped.col+j,popped.distance+1));
                    distance[popped.row+i][popped.col+j] = popped.distance+1;
                }
            }
        }
        return -1;
    }
}
