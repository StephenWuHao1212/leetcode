
/*

	Given two strings s and t, determine if they are isomorphic.
	
	Two strings are isomorphic if the characters in s can be replaced to get t.
	
	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
	
	For example,
	Given "egg", "add", return true.
	
	Given "foo", "bar", return false.
	
	Given "paper", "title", return true.
	
	Note:
	You may assume both s and t have the same length.
	
	
	
	Hashtable to store the corresonding relationship
*/


import java.util.*;
public class Solution {
    public static boolean isIsomorphic(String s, String t) {
       Hashtable<Character, Character> tr = new Hashtable<Character, Character>();
       for(int i = 0; i < s.length(); i++){
    	   Character c = tr.get(s.charAt(i));
    	   if(c != null){
    		   if(c != t.charAt(i)) return false;
    	   }
    	   else{
    		   if(tr.containsValue(t.charAt(i))) return false;
    		   tr.put(s.charAt(i), t.charAt(i));
    	   }
       }
       return true;
    }
    
    public static void main(String[] args){
    	System.out.println(isIsomorphic("egg", "baa"));
    	System.out.println(isIsomorphic("egg", "bad"));
    	System.out.println(isIsomorphic("ab", "aa"));
    	System.out.println(isIsomorphic("egg", "baa"));



    }
}