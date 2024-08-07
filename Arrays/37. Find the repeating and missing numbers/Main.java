/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
    // 
	public static void main(String[] args) {
	    int array[] = {3,1,2,5,3};
		// BruteForce -> from 1 to n we can check which one is repeating and missing.
		// Optimized ->
		int xor = 0;
		for(int i : array){
		    xor ^= i;
		}
		for(int i=1;i<=array.length;i++){
		    xor ^= i;
		}
		// the repeating and the non repeating numbers are the only xored in this.
		int i=0;
		while(xor>0){
		    if((xor&1)!=0){
		        break;
		    }
		    i++;
		}
		int onbit = 0;
		int offbit = 0;
		for(int index=0;index<array.length;index++){
		    if(((index+1)&(1<<i))!=0){
		        onbit^=index+1;
		    }
		    else{
		        offbit ^= index+1;
		    }
		    if((array[index]&1<<i)!=0){
		        onbit^=array[index];
		    }
		    else{
		        offbit^=array[index];
		    }
		}
		System.out.print(onbit + " - "+offbit);
	}
}
