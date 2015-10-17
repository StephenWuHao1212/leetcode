/*
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:

	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
	public String convert(String s, int numRows) {
	    int len = s.length();
	    if(len == 0 || len <= numRows || numRows <= 1) return s;
	    String[] rows = new String[numRows];
	    for(int i = 0; i < rows.length; i++){
	        rows[i] = s.substring(i, i + 1);
	    }
	    int T = 2 * numRows - 2;
	    for(int i = rows.length; i < len; i++){
	        int index = i % T;
	        if(index < numRows){
	            rows[index] = rows[index] + s.substring(i, i + 1);
	        }
	        else {
	            rows[T - index] = rows[T - index] + s.substring(i, i + 1);
	        }
	    }
	    String ans = new String();
	    for(int i = 0; i < rows.length; i++){
	        ans += rows[i];
	    }
	    return ans;
	}
}