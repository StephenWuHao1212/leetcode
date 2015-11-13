/*

	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

	Examples:
	pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.
	Notes:
	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.



	string split and hashtable
*/


import java.util.*;
public class Solution {
    public static boolean wordPattern(String pattern, String str) {
    	if(pattern.isEmpty() && !str.isEmpty()) return false;
    	if(pattern.isEmpty() && str.isEmpty()) return true;
    	if(!pattern.isEmpty() && str.isEmpty()) return false;
        Hashtable<Character, String> t = new Hashtable<Character, String>();
        String[] string = str.split(" ");
        if(string.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
        	if(t.get(pattern.charAt(i)) == null) {
            	if(t.containsValue (string[i])) return false;
        		t.put(pattern.charAt(i), string[i]);
        	}
        	else if( !t.get(pattern.charAt(i)).equals(string[i])) {
        		return false;
        	}
         }
        return true;
    }


    public static void main(String[] args) {
    	System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}