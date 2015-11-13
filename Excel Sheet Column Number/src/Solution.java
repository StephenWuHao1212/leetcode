/*

	Given a column title as appear in an Excel sheet, return its corresponding column number.

	For example:

	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 


	    base 26
 */

public class Solution {
	public static int titleToNumber(String s) {
		int base = 1;
		int ans = 0;
		for(int i = s.length() - 1; i > -1; i--){
			ans += (int)(s.charAt(i) - 'A' + 1) * base;
			base *= 26;
		}
		return ans;
	}

	public static void main(String[] args){
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("BA"));
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("NTP"));

	}
}