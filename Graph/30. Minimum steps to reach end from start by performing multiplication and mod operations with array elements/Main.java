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
	int MOD = 100000;
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        int ans[] = new int[MOD+1];
        Arrays.fill(ans,-1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        ans[start] = 0;
        while(!q.isEmpty()){
            int popped = q.poll();
            if(popped == end) return ans[popped];
            for(int i=0;i<arr.length;i++){
                int newVal = (popped * arr[i])%MOD;
                if(ans[newVal]==-1){
                    ans[newVal] = ans[popped]+1; 
                    q.add(newVal);
                }
            }
        }
        return -1;
    }
}
