/*

	Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".
			
	Apply Binary adding rule, addition result and carry bit
*/

public class Solution {
    public static String addBinary(String a, String b) {
        String ans = new String();
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        int bitA = 0;
        int bitB = 0;
        for(int i = lenA - 1, j = lenB - 1; i > -1 || j > -1; i--, j--){
        	bitA = i > -1 ? Integer.parseInt(a.substring(i, i + 1)) : 0;
        	bitB = j > -1 ? Integer.parseInt(b.substring(j, j + 1)) : 0;
        	int temp = bitA + bitB + carry;
        	if(temp == 0 || temp == 2) ans = "0" + ans;
        	else ans = "1" + ans;
        	carry = temp < 2 ? 0 : 1;
        }
        if(carry != 0) ans = "1" + ans;
        return ans;
    }
    
    public static void main(String[] args){
    	String a = "111000";
    	String b = "100";
    	System.out.println(addBinary(a, b));
    }
}