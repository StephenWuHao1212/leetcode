/*
	Given an index k, return the kth row of the Pascal's triangle.
	
	For example, given k = 3,
	Return [1,3,3,1].





	a ans list
	if k < 1
		return ans 
	loop i from 1 to k
		loop index from 0 to i - 1
			if index equals to 0
				add 1 into ans
			else if index equals to i - 1
				 add 1 into ans
				 pop ans
			else 
				pop one from ans
				add the first number of ans and the popped one into ans
	return ans
	
*/


import java.util.*;
public class Solution {
    public static List<Integer> getRow(int rowIndex) {
    	LinkedList<Integer> ans = new LinkedList<Integer>();
        if(rowIndex < 0) return ans;
        for(int i = 1; i <= rowIndex + 1; i++){
        	for(int index = 0; index < i; index++){
        		if(index == 0){
        			ans.add(1);
        		}
        		else if(index == i - 1){
        			ans.add(1);
        			ans.pop();
        		}
        		else{
        			ans.add(ans.pop() + ans.peek());
        		}
        	}
        }
        return ans;
    }
    
    public static void main(String[] args){
    	System.out.println(getRow(-1));
    	System.out.println(getRow(0));
    	System.out.println(getRow(1));
    	System.out.println(getRow(2));
    	System.out.println(getRow(3));
    	System.out.println(getRow(5));

    }
}











