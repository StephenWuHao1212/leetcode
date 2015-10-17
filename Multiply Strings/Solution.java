/*
	Given two numbers represented as strings, return multiplication of the numbers as a string.

	Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for(int i = 0; i < len1; i++){
            int l1 = num1.charAt(len1 - 1 - i) - '0';
            for(int j = 0; j < len2; j++){
                int l2 = num2.charAt(len2 - j - 1) - '0';
                ans[i + j] = ans[i + j] + l2 * l1;
            }
        }
        int carry = 0;
        String ansString = "";
        int len = 0;
        for(int k = ans.length - 1; k > -1; k--){
            if(ans[k] != 0){
                len = k + 1;
                break;
            }
        }
        for(int k = 0; k < len; k++){
            ans[k] = ans[k] + carry;
            carry = ans[k] / 10;
            ans[k] = ans[k] % 10;
        }
        for(int k = len - 1; k > -1; k--){
            ansString = ansString + Integer.toString(ans[k]);
        }
        
        if(carry != 0){
            ansString = Integer.toString(carry) + ansString;
        }
        return ansString == ""?"0":ansString;
    }  
}