/*

Write a function that takes an unsigned integer and
returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
so the function should return 3.



loop 32 times to get bit
	- if n == 0
		break the loop
		
*/


public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int ans = 0;
    	for(int i = 0; i < 32; i++){
    		if(n == 0) return ans;
    		if((n & 1) == 1) ans++;
    		n = n >> 1;
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	System.out.println(Integer.toBinaryString(2));
    	System.out.println(hammingWeight(2));
    	System.out.println(Integer.toBinaryString(3));
    	System.out.println(hammingWeight(3));
    	System.out.println(Integer.toBinaryString(0));
    	System.out.println(hammingWeight(0));
    	System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    	System.out.println(hammingWeight(Integer.MAX_VALUE));
    	System.out.println(Integer.toBinaryString(12039));
    	System.out.println(hammingWeight(12039));
    }
}