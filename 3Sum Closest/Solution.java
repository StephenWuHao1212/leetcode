/*
	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i <= nums.length - 3; i++){
            int start = i + 1; int end = nums.length - 1;
            while(start < end){
                int curr = nums[start] + nums[end] + nums[i];
                ans = Math.abs(curr - target) < Math.abs(ans - target)?curr:ans;
                if(curr > target) end--;
                else if(curr < target) start++;
                else return target;
            }
        }
        return ans;
    }
}