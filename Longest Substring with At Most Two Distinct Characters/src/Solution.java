/*

	Given a string, find the longest substring that contains only two unique characters.
	
	
	
	similar to sliding window, use a hashmap to calculate the size of the window
	
	
	
	this is the scalable version for k unique characters
	
	a integer for current maximum substring length maxLen 
	a integer for startPosition
	a string to store the current longest substring currString
	loop i from 0 to the end of the string
		if the map contains the character at index i
			increase the count
		else
			put it into the map
		if the size of the map reaches 3, meaning that it is beyond the size of the window
			get the substring from start to i
			if length of the substring is greater than maxLen
				renew the maxLen and the currString
			renew the size of the window
			while size of the map is too big
				if the number of char at index start is greater than 1
					decrease the number
				else remove it
				start++
	return currString
	
*/

import java.util.*;
public class Solution{
	public static String maxSubStringKUniqueChars(String s, int k) {
		if(s.length() < 3) return s;
		int maxLen = 0;
		int startPosition = 0;
		String ans = new String();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if(map.containsKey(s.charAt(i))){
				map.put(c, map.get(c) + 1);
			}
			else{
				map.put(c, 1);
			}
			if(map.size() > k){
				String substring = s.substring(startPosition, i);
				if(substring.length() > maxLen){
					maxLen = substring.length();
					ans = substring;
				}
				while(map.size() > k){
					Character c1 = s.charAt(startPosition);
					if(map.get(c1) > 1){
						map.put(c1, map.get(c1) - 1);
					}
					else
						map.remove(c1);
					startPosition++;
				}
			}
		}
		if(ans.isEmpty()){
			return s;
		}
		return ans;
	}
	
	public static void main(String[] args){
		System.out.println(maxSubStringKUniqueChars("eceba", 2));
		System.out.println(maxSubStringKUniqueChars("eeeeeeeee", 2));
		System.out.println(maxSubStringKUniqueChars("", 2));
		System.out.println(maxSubStringKUniqueChars("e", 2));
		System.out.println(maxSubStringKUniqueChars("ee", 2));
		System.out.println(maxSubStringKUniqueChars("ec", 2));
		System.out.println(maxSubStringKUniqueChars("eebebebebebebb", 2));
		System.out.println(maxSubStringKUniqueChars("eebebebebebebbc", 2));
		System.out.println(maxSubStringKUniqueChars("asdfghjkl", 2));
	}
}