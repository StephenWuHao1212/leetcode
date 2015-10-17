/*
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	You are given a target value to search. If found in the array return its index, otherwise return -1.

	You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        if(len == 1) return nums[0] == target ? 0:-1;
        int ans = -1; int start = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }
}