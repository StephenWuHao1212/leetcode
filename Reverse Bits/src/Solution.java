/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).



get the binary representation first
from the first one of the representation, calculate the reversed integer 
*/


public class Solution {
    // you need treat n as an unsigned value
	
	// my version
//    public static int reverseBits(int n) {
//        String b = Integer.toBinaryString(n);
//        int ans = 0;
//        int base = 1;
//        while(b.length() != 32){
//        	b = "0" + b;
//        }
//        for(int i = 0; i < b.length(); i++){
//        	ans += base * (int)(b.charAt(i) - '0');
//        	base *= 2;
//        }
//        return ans;
//    }
    
    public static int reverseBits(int n){
    	int res = 0;
    	for(int i = 0; i < 32; i++){
    		res = (res << 1) | (n & 1);
    		n = n >> 1;
    	}
    	return res;
    }
    
    
    public static void main(String[] args){
    	System.out.println(reverseBits(43261596));
    	System.out.println(reverseBits(0));
    	System.out.println(reverseBits(Integer.MAX_VALUE));
    	System.out.println(reverseBits(1124));

    }
}