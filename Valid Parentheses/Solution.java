/*
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> st = new<Character> Stack();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                if(st.empty() || st.peek() != '(') return false;
                else st.pop();
            }
            else if(s.charAt(i) == '}'){
                if(st.empty() || st.peek() != '{') return false;
                else st.pop();
            }
            else if(s.charAt(i) == ']'){
                if(st.empty() || st.peek() != '[') return false;
                else st.pop();
            }
        }
        if(st.empty()) return true;
        else return false;
    }
}