/* 
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
	
	backtracing, store the previous status of the permutation and also the 
	used number to skip duplicates
	

*/

import java.util.*;

public class Solution{
	public static void main(String[] args){
		int[] nums = {1,2,1,2,1};
		List<List<Integer>> ans = permuteUnique(nums);
		for(int i = 0; i < ans.size(); i++){
			System.out.println(ans.get(i).toString());
		}
	}
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
    		List<Integer> currentUsingNumber = new LinkedList<Integer>();
    		for(int i = 0; i < nums.size(); i++){
    			if(!currentUsingNumber.contains(nums.get(i))){
    				currentUsingNumber.add(nums.get(i));
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
    
}