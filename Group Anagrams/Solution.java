/*
	Given an array of strings, group anagrams together.

	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:

	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note:
	For the return value, each inner list's elements must follow the lexicographic order.
	All inputs will be in lower-case.
*/

import java.util.*;

public class Solution {
    public class alphabetCompare implements Comparator{
        public int compare(Object sa, Object sb){
            String a = (String)sa;
            String b = (String)sb;
            for(int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++){
                if(a.charAt(i) < b.charAt(j)) return -1;
                if(a.charAt(i) > b.charAt(j)) return 1;
            }
            return 0;
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String, List<String>> map = new TreeMap<String, List<String>>();
        for(String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sc = new String(c);
            if(map.containsKey(sc)){
                map.get(sc).add(s);
            }
            else{
                List<String> tmp = new LinkedList<String>();
                tmp.add(s);
                map.put(sc, tmp);
            }
        }
        
        List<List<String>> ans = new LinkedList<List<String>>();
        while(!map.isEmpty()){
            List<String> t = map.pollFirstEntry().getValue();
            Collections.sort(t, new alphabetCompare());
            ans.add(t);
        }
        return ans;
    }
}