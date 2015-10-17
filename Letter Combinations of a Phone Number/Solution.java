/*
	Given a digit string, return all possible letter combinations that the number could represent.

	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if(digits.length() == 0) return ans;
        int num = Integer.parseInt(digits);
        ans = helper(ans, num);
        return ans;
    }
    
    public List<String> helper(List<String> inputStr, int num){           
        List<String> ans = new LinkedList<String>();
        if(inputStr.isEmpty()){
            int curr = num % 10;
            num = num / 10;
            String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
            if(str[curr] == "") {
                ans = inputStr;
            }
            for(int i = 0; i < str[curr].length(); i++){
                ans.add(str[curr].substring(i, i + 1));
            }
            ans = helper(ans, num);
            return ans;
        }
        else if(num != 0){
            int curr = num % 10;
            num = num / 10;
            String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
            if(str[curr] == "") {
                ans = inputStr;
            }
            else{
                for(int i = 0; i < str[curr].length(); i++){
                    for(int j = 0; j < inputStr.size(); j++){
                        ans.add(str[curr].substring(i, i + 1) + inputStr.get(j));
                    }
                }
            }
            ans = helper(ans, num);
            return ans;
        }
        else return inputStr;
    }
}