/*

	Given a positive integer, return its corresponding column title as appear in an Excel sheet.

	For example:

	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 


	base 26
	be careful about the corner case when n = m * 26
 */

public class Solution {
	public static String convertToTitle(int n) {
		String ans = new String();
		while(n > 26){
			if(n % 26 == 0){
				ans = 'Z' + ans;
				n = n / 26 - 1;
			}
			else{
				ans = (char)('A' + n % 26 - 1) + ans;
				n = n / 26;
			}
		}
		ans = (char)('A' + n - 1) + ans;
		return ans;
	}

	public static void main(String[] args){
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(53));

		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(10000));



	}
}