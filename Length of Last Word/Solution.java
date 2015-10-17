/*
	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

	If the last word does not exist, return 0.

	Note: A word is defined as a character sequence consists of non-space characters only.

	For example, 
	Given s = "Hello World",
	return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty()) return 0;
        boolean isStart = false;
        int ans = 0;
        for(int i = s.length() - 1; i > -1; i--){
            char curr = s.charAt(i);
            if(isStart == false){
                if(curr == ' ')
                    continue;
                else{
                    isStart = true;
                    ans++;
                }
            }
            else{
                if(curr == ' '){
                    return ans;
                }
                else{
                    ans++;
                }
            }
            
        }
        return ans;
    }
}