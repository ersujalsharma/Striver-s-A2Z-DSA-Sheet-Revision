/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	   // int isConnected[][] = {{1,1,0},{1,1,0},{0,0,1}};
	   int isConnected[][] = {{1,0,0},{0,1,0},{0,0,1}};
		int count = 0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                help(isConnected,i,visited);
                count++;
            }
        }
        System.out.print(count);
    }
    public static void help(int[][] isConnected,int index,boolean[] visited){
        visited[index] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[index][i]==1){
                if(!visited[i]){
                    help(isConnected,i,visited);
                }
            }
        }
	}
}
