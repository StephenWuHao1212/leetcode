/*
	Implement strStr().

	Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(needle.length() > haystack.length()) return -1;
        else{
            int len = needle.length();
            int tar = needle.hashCode();
            for(int i = 0; i < haystack.length() ; i++){
                if(i + len > haystack.length()) return -1;
                else{
                    int hashHay = haystack.substring(i, i + len).hashCode();
                    if(hashHay == tar) return i;
                }
            }
            return -1;
        }
    }
}