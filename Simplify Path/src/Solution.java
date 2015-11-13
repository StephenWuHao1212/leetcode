/*

	Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c





	stack, go over the whole list
*/




import java.util.*;
public class Solution {
    public static String simplifyPath(String path) {
    	if(path.isEmpty()) return path;
        Stack<String> stack = new Stack<String>();
        int begin = 0;
        int end = 1;	
        while(end < path.length()){
        	while(begin < path.length() && path.charAt(begin) == '/') begin++;
        	if(begin >= path.length()) break;
        	end = begin + 1;
        	while(end < path.length() && path.charAt(end) != '/') end++;
        	System.out.println(path.substring(begin, end));
        	if(path.substring(begin, end) != ".." && path.substring(begin, end) != ".") stack.add(path.substring(begin, end));
        	begin = end;
        }
        String ans = new String();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
        	ans = '/' + stack.pop() + ans;
        }
        return ans;
       
    }
    
    public static void main(String[] args){
    	System.out.println(simplifyPath("b//d.../c/"));
    	System.out.println(simplifyPath("/..//"));
    	System.out.println(simplifyPath("/.."));
    	System.out.println(simplifyPath(".../"));
    	System.out.println(simplifyPath("/."));

    }
}