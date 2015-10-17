/*
	Given a sorted array of integers, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        return helper(nums, 0, len - 1, target);
    }
    
    public int[] helper(int[] nums, int start, int end, int target){
        int[] ans  = {-1, -1};
        if(start > end){
            return ans;
        }
        else if(start == end) {
            if(nums[start] == target) return findTheIndex(nums, start, target);
            else return ans;
        }
        else{
            int len = end - start + 1;
            int mid; int index;
            if(len % 2 == 0){ 
                index = (end - start) / 2 + start;
                mid = (nums[index] + nums[index + 1]) / 2;
            }
            else{
                index = (end - start) / 2 + start;
                mid = nums[index];
            }
            if(mid < target) return helper(nums, index + 1, end, target);
            else if(mid > target) return helper(nums, start, index, target);
            else if(mid == target && nums[index] == target) return findTheIndex(nums, index, target);
            else return ans;
        }
            
    }
    
    public int[] findTheIndex(int[] nums, int index, int target){
        int left = index; 
        int right = index;
        int[] ans = {index, index};
        for(int i = 0; i < nums.length / 2 + 1; i++){
            if(left - 1 >= 0 && nums[left - 1] == target) left -= 1;
            if(right + 1 < nums.length && nums[right + 1] == target) right += 1;
        }
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
}