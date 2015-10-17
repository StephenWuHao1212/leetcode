/*
	You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

	For example, given:
	s: "barfoothefoobarman"
	words: ["foo", "bar"]

	You should return the indices: [0,9].
	(order does not matter).
*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        if(words.length == 0) {
             result.add(0);
             return result;
        }
        if(s.isEmpty()) return result;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        int len = words[0].length();
        for(int j = 0; j < len; j++){
            int count = 0;
            int start = j;
            Map<String, Integer> curr = new HashMap<String, Integer>();
            for(int i = j; i <= s.length() - len; i += len){
                String sub = s.substring(i, len + i);
                if(map.containsKey(sub)){
                     if(curr.containsKey(sub)) curr.put(sub, curr.get(sub) + 1);
                     else curr.put(sub, 1);
                     count++;
                     while(curr.get(sub) > map.get(sub)){
                         String left = s.substring(start, start + len);
                         curr.put(left, curr.get(left) - 1);
                         count--;
                         start += len;
                     }
                     if(count == words.length){
                         result.add(start);
                         String left = s.substring(start, start + len);
                         start += len;
                         count--;
                         curr.put(left, curr.get(left) - 1);
                     }
                }
                else{
                    start = i + len;
                    count = 0;
                    curr.clear();
                }
            }
        }
        return result;
        
    }
}