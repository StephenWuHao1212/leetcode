/*
	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.

	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, target);
    }
    public int helper(int[] nums, int start, int end, int target){
        if(start == end) return nums[start] < target? end + 1: end;
        int len = end - start + 1;
        int mid;
        int index = (end - start) / 2 + start;
        if(len % 2 == 0){
            mid =  (nums[index] + nums[index + 1]) / 2;
        }
        else{
            mid = nums[index];
        }
        if(mid == target) return nums[index] == target?index:index + 1;
        else if(mid < target) return helper(nums, index + 1, end, target);
        else return helper(nums, start, index, target);
    }
}