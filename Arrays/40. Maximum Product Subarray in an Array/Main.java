/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main{
    // Maximum Product SubArray in an array.
    public static void main(String... args){
        int arr[] = {1,2,3,4,5,0};
        /*
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int prod = 1;
            for(int j=i;j<nums.length;j++){
                prod *= nums[j];
                max = Math.max(max,prod);
            }
        }
        System.out.print(max);
        */
        /*
        int prefix = 1;
        int suffix = 1;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.length-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
        }
        System.out.print(max);
        */
        // Kadanes ,
        // Maintain two products, first is min for negative, and second one is max for pos;
        
        int prod1 = arr[0];
        int prod2 = arr[0];
        int result = arr[0];
        for(int i=1;i<arr.length;i++){
            int temp = Math.max(arr[i],Math.max(arr[i]*prod1,arr[i]*prod2));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;
            result = Math.max(result,prod1);

        }
        System.out.print(result);
    }
}