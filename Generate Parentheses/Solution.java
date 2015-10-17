/*
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<String>();
        if(n <= 0) return ans;
        ans.add("()");
        if(n == 1) return ans;
        else{
            for(int i = 1; i < n; i++){
                Set<String> set = new HashSet<String>();
                for(int j = 0; j < ans.size(); j++){
                    String curr = ans.get(j);
                    for(int k = 0; k <= curr.length(); k++){
                        if(k == 0){
                            set.add("()" + curr);
                        }
                        else if(k == curr.length()){
                            set.add(curr + "()");
                        }
                        else{
                            set.add(curr.substring(0, k) + "()" + curr.substring(k, curr.length()));
                        }
                    }
                }
                ans.clear();
                ans.addAll(set);
            }
        }
        return ans;
    }
}