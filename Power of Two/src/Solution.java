/*

	Given an integer, write a function to determine if it is a power of two.



	bit manipulation
*/

public class Solution {
    public static boolean isPowerOfTwo(int n) {
    	  if(n <= 0) return false;
          int m = n - 1;
          if((m & n) == 0) return true;
          else return false;
    }
    
    public static void main(String[] args) {
    	System.out.println(isPowerOfTwo(32));
    }
}