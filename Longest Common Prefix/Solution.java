/*
	Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String longest = new String();
        int minLen = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            minLen = Math.min(minLen, strs[i].length());
        }
        for(int j = 0; j < minLen; j++){
            String curr = strs[0].substring(0, j + 1);
            for(int i = 0; i < strs.length; i++){
                if(strs[i].indexOf(curr) != 0) return longest;
            }
            longest = curr;
        }
        return longest;
    }
}