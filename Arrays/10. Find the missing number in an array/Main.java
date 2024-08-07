/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. 
    // Find the number(between 1 to N), that is not present in the given array.
	public static void main(String[] args) {
		int N = 5, array[] = {1,2,4,5};
		// Brute Force - > check each number from 1 to n is it exist or not, the one, which doesn't will the ans.
		/*
		int ans = 0;
		for(int i =1;i<=N;i++){
		    boolean flag = false;
		    for(int el : array){
		        if(el == i){
		            flag = true;
		            break;
		        }
		    }
		    if(!flag){
		        ans = i;
		        break;
		    }
		}
		System.out.print(ans);
		*/
		// Here Mathematics Introduces in Programming,if you know the formula of sum of n numbers it will easy.
		int sum = 0;
		for(int i : array){
		    sum += i;
		}
		System.out.print((N*(N+1))/2 - sum);
	}
}
