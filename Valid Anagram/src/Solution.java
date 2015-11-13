/*

	Given two strings s and t, write a function to determine if t is an anagram of s.

	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.
	
	Note:
	You may assume the string contains only lowercase alphabets.
	
	
	
	
	Hashtable or sort
*/

import java.util.*;
public class Solution {
    public static boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        for(int i = 0; i < cs.length; i++){
        	if(cs[i] != ct[i]) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	System.out.println(isAnagram("anagram", "nagaram"));
    	System.out.println(isAnagram("anram", "nagaram"));
    	System.out.println(isAnagram("a", "a"));
    	System.out.println(isAnagram("a", "b"));
    	System.out.println(isAnagram("anagram", ""));
    	System.out.println(isAnagram("", ""));
    }
}