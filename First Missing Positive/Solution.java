/*
	Given an unsorted integer array, find the first missing positive integer.

	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.

	Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 1;
        Arrays.sort(nums);
        if(nums[len - 1] < 1) return 1;
        for(int i = 0; i < len; i++){
           if(i == 0){
               if(nums[i] > 0 && nums[i] != 1) return 1;
           }
           else if(nums[i] > 0 && nums[i - 1] <= 0){
               if(nums[i] != 1) return 1;
           }
           else if(nums[i] > 0 && nums[i - 1] > 0){
               if(nums[i] - nums[i - 1] > 1) return nums[i - 1] + 1;
           }
        }
        return nums[len - 1] + 1;
    }
}