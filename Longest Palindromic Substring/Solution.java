/* Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there 
exists one unique longest palindromic substring.

*/

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return s;
        return helper(s, 0, s.substring(s.length() / 2, s.length() / 2 + 1));
    }
    
    public String helper(String s, int index, String currentMax){
        String tmp;
        if(index >= s.length()) return currentMax;
        if(index >= 0 || index < s.length()) {
            tmp = isPalindromic(s, index, index);
            currentMax = currentMax.length() > tmp.length()?currentMax:tmp;
            if(index - 1 >= 0){
                tmp = isPalindromic(s, index - 1, index);
                currentMax = currentMax.length() > tmp.length()?currentMax:tmp;
            }
            if(index + 1 < s.length()){
                tmp = isPalindromic(s, index, index + 1);
                currentMax = currentMax.length() > tmp.length()?currentMax:tmp;
            }
        }
        tmp = helper(s, index + 1, currentMax);
        currentMax = currentMax.length() > tmp.length()?currentMax:tmp;
        return currentMax;
        
    }
    
    public String isPalindromic(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--; end++;
        }
        return s.substring(start + 1, end);
    }
}