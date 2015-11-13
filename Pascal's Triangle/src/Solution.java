/*
	Given numRows, generate the first numRows of Pascal's triangle.
	
	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
	
	list for current row
	ans for the whole triangle
	
	if numRows < 1, return the empty ans
	index represent the current position of the current row, 
	loop i for 1 to numRows
		if i equals to 1
			add 1 into list
			add list into ans
			continue
		refresh list
		lastList represent the last row of the triangle 
		get the last list from ans
		loop index for 0 to i - 1
			if index equals to 0 or i - 1
				add 1 into list
			else
				add lastList[index - 1] + lastList[index] into list
		add list into ans
	return ans
		
*/

import java.util.*;
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(numRows < 1) return ans;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i <= numRows; i++){
        	if(i == 1){
        		list.add(1);
        		ans.add(list);
        		continue;
        	}
        	list = new LinkedList<Integer>();
        	LinkedList<Integer> lastList= (LinkedList<Integer>)ans.peekLast();
        	for(int index = 0; index < i; index++){
        		if(index == 0 || index == i - 1){
        			list.add(1);
        		}
        		else{
        			list.add(lastList.get(index - 1) + lastList.get(index));
        		}
        	}
        	ans.add(list);
        }
        return ans;
    }
    
    public static void main(String[] args){
    	System.out.println(generate(-1));
    	System.out.println(generate(0));
    	System.out.println(generate(1));
    	System.out.println(generate(2));
    	System.out.println(generate(3));
    	System.out.println(generate(5));



    }
}