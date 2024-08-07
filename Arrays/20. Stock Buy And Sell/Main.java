/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // prices = [7,1,5,3,6,4]
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		// Brute Force -> Check each pair and find the max profit.
		int max = 0;
// 		for(int i=0;i<prices.length;i++){
// 		    for(int j=i+1;j<prices.length;j++){
// 		        max = Math.max(max,prices[j]-prices[i]);
// 		    }
// 		}
        int buy = Integer.MAX_VALUE;
        for(int i : prices){
            if(i<buy){
                buy = i;
            }
            else{
                max = Math.max(i-buy,max);
            }
        }
		System.out.print(max);
	}
}
