/*
 *  Divide two integers without using multiplication, division and mod operator.
 *  
 *  If it is overflow, return MAX_INT.
 * 
 * 
 * Solution:
 * 		Every Integer can be represented as a0 * 2^0 + a1 * 2^1 + ... + an * 2^n
 *  	Represent the result and dividend
 *
 * 
 */


public class Solution{
	public static int divide(int dividend, int divisor){
		 if(divisor == 0) return Integer.MAX_VALUE;
			if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
			long newDividend = Math.abs((long)dividend);
			long newDivisor = Math.abs((long)divisor);
			int result = 0;
			while(newDividend >= newDivisor){
				int numShift = 0;
				while(newDividend >= (newDivisor << numShift)){
					numShift++;
				}
				result += 1 << (numShift - 1);
				newDividend -= newDivisor << (numShift - 1);
			}
			if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) return result;
			else return -result; 
	}
	
	public static void main(String[] args){
		System.out.println(divide(-2147483648,-1));
	}
}