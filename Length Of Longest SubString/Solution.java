public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int max = 0;
        int j = 1;
        for(int i = 0; i < s.length(); i++){
            for(; j <= s.length(); j++){
                if(i == j) continue;
                String sub = s.substring(i, j);
                if(sub.indexOf(s.charAt(j - 1)) == sub.length() - 1){
                    if(max < j - i) max = j - i;
                }
                else break;
            }
        }
        return max;
    }
}