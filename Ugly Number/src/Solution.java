/*


	Write a program to check whether a given number is an ugly number.
	
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	
	Note that 1 is typically treated as an ugly number.



	recursively determine whether the number is ugly.
	if can be divided by 2,3,5
		test ugly again
	if it is 1
		return true
	return false
*/

public class Solution {
    public static boolean isUgly(int num) {
        if(num == 1) return true;
        if(num % 2 == 0){
        	return isUgly(num / 2);
        }
        else if(num % 3 == 0){
        	return isUgly(num / 3);
        }
        else if(num % 5 == 0){
        	return isUgly(num / 5);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	System.out.println(isUgly(1));
    	System.out.println(isUgly(2));
    	System.out.println(isUgly(3));
    	System.out.println(isUgly(4));
    	System.out.println(isUgly(5));
    	System.out.println(isUgly(19));
    	System.out.println(isUgly(30));

    }
}