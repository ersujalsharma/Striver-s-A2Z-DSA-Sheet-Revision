/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Count Maximum Consecutive One's in the array
	public static void main(String[] args) {
		int[] prices = {1, 1, 0, 1, 1, 1};
		// Count 1's and whenever 0 occur just store the no of one's 
		// in max and start again counting from 1.
		int max = 0;
		int count = 0;
		for(int i=0;i<prices.length;i++){
		    if(prices[i] == 0){
		        count = 0;
		    }
		    else{
		        count++;
		    }
		    max = Math.max(count,max);
		}
		System.out.println(max);
	}
}
