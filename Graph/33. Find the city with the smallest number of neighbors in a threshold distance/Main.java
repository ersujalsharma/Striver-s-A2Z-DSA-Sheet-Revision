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
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans[] = new int[n];
        int[][] distance = new int[n][n];
        for(int i[] : distance) Arrays.fill(i,-1);
        for(int edge[] : edges){
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        for(int i=0;i<n;i++){
            distance[i][i] = 0;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(distance[i][k]!=-1 && distance[k][j]!=-1 && ( distance[i][k]+distance[k][j]<distance[i][j] || distance[i][j] == -1 )){
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        int ans = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(distance[i][j]!=-1 && distance[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=smallest){
                smallest = count;
                ans = i;
            }
        }
        return ans;
    }
}
