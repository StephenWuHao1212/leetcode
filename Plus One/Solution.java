/*
	Given a non-negative number represented as an array of digits, plus one to the number.

	The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int res = 0;
        int i = digits.length - 1;
        for(;i > -1; i--){
            if(i == digits.length - 1){
                int sum = digits[i] + 1;
                digits[i] = sum % 10;
                res = sum / 10;
            }
            else{
                if(res == 0) break;
                else{
                    int sum = digits[i] + res;
                    digits[i] = sum % 10;
                    res = sum / 10;
                }
            }
        }
        
        if(i == -1 && res != 0){
            int[] ans = new int[digits.length + 1];
            ans[0] = res;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
        return digits;
    
    }
}