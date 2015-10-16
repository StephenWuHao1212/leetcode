/*
	Given an array of non-negative integers, you are initially positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
	
	Solution:
		if current index + the maximum jump length can be greater the current maximum index,
		update the current maximum index
		if the current maximum index can reach the end of the array, return true
*/


public class Solution{
	public static boolean canJump(int[] nums){
		if(nums.length <= 1) return true;
		int max = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(max <= i && nums[i] == 0) return false;
			if(i + nums[i] > max) max = i + nums[i];
			if(max >= nums.length - 1) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] nums = {0,1};
		System.out.println(canJump(nums));
	}
	
}