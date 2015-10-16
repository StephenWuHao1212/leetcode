/* 
	Given a collection of numbers, return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

	Solution: Backtracing, store the previous status of the permutation
*/

import java.util.*;

public class Solution{
	public static void main(String[] args){
		int[] nums = {1,2,3,4};
		List<List<Integer>> ans = permute(nums);
		for(int i = 0; i < ans.size(); i++){
			System.out.println(ans.get(i).toString());
		}
	}
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans = new LinkedList<List<Integer>>();
    	List<Integer> numList = new LinkedList<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		numList.add(nums[i]);
    	}
    	if(nums.length < 2){
    	    ans.add(numList);
    		return ans;
    	}
    	List<Integer> list = new LinkedList<Integer>();
    	helper(ans, list, numList);
    	return ans;
    	
    }
    
    public static void helper(List<List<Integer>> ans, List<Integer> list, List<Integer> nums){
    	if(nums.size() == 1){
    		list.addAll(nums);
    		ans.add(list);
    	}
    	else{
    		for(int i = 0; i < nums.size(); i++){
    			List<Integer> newList = new LinkedList<Integer>();
    			newList.addAll(list);
    			List<Integer> newNums = new LinkedList<Integer>();
    			newNums.addAll(nums);
    			newList.add(newNums.get(i));
    			newNums.remove(i);
    			helper(ans, newList, newNums);
    		}
    	}
    }
    
}