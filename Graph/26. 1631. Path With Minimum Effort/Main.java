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
	class Triple implements Comparable<Triple>{
        int diffrence;
        int row;
        int col;
        public Triple(int diffrence,int row,int col){
            this.diffrence = diffrence;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triple other){
            return this.diffrence-other.diffrence;
        }
    }
    static int row[] = {-1,0,1,0};
    static int col[] = {0,-1,0,1};
    public int minimumEffortPath(int[][] heights) {
        int minDifference[][] = new int[heights.length][heights[0].length];
        for(int i[] : minDifference) Arrays.fill(i,Integer.MAX_VALUE);
        minDifference[0][0] = 0;
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        pq.add(new Triple(0,0,0));
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int diff = t.diffrence;
            int r = t.row;
            int c = t.col;
            if(r == heights.length-1 && c == heights[0].length-1) return diff;
            for(int i=0;i<4;i++){
                int newr = r+row[i];
                int newc = c+col[i];
                if(newr>=0 && newc>=0 && newr<heights.length && newc<heights[0].length){
                    int newEffort = Math.max(Math.abs(heights[r][c]-heights[newr][newc]),diff);
                    if(newEffort<minDifference[newr][newc]){
                        minDifference[newr][newc] = newEffort;
                        pq.add(new Triple(newEffort,newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}
