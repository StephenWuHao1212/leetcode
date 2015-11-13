/*
	Given a sorted integer array without duplicates, return the summary of its ranges.

	For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	
	
	
	two pointers
*/

import java.util.*;
public class Solution {
    public static List<String> summaryRanges(int[] nums) {
    	List<String> ans = new LinkedList<String>();
        if(nums.length == 0) return ans;
        else if(nums.length == 1){
        	ans.add(Integer.toString(nums[0]));
        	return ans;
        }
        else{
        	int p1 = 0;
        	int p2 = 1;
        	int curr = nums[p1];
        	while(true){
        		if(p2 >= nums.length){
        			if(curr == nums[p1]) ans.add(Integer.toString(nums[p1]));
        			else ans.add(Integer.toString(nums[p1]) + "->" + Integer.toString(curr));
        			return ans;
        		}
        		if(nums[p2] == curr + 1){
        			curr = nums[p2];
        			p2++;
        		}
        		else{
        			if(curr == nums[p1]) ans.add(Integer.toString(nums[p1]));
        			else ans.add(Integer.toString(nums[p1]) + "->" + Integer.toString(curr));
        			p1 = p2;
        			curr = nums[p2];
        			p2++;
        		}
        	}
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {2,5,6,7,9,10,12};
    	System.out.println(summaryRanges(nums));
    }
}