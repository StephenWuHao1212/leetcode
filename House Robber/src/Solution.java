/*

	You are a professional robber planning to rob houses along a street. 
	Each house has a certain amount of money stashed, 
	the only constraint stopping you from robbing each of them is that 
	adjacent houses have security system connected and it will automatically 
	contact the police if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money of each
	house, determine the maximum amount of money you can rob tonight without alerting the police.




	dynamic programming 
	the maximum money when arriving i house is either money(i - 1) or money(i - 2) + money(i)

*/


public class Solution {
    public static int rob(int[] nums) {
    	if(nums.length == 0) return 0;
        int[] money = new int[nums.length];
        for(int i = 0; i < money.length; i++){
        	if(i == 0){
        		money[0] = Math.max(0 + nums[0], 0);
        	}
        	else if(i == 1){
        		money[1] = Math.max(0 + nums[1], money[0]);
        	}
        	else
        		money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        if(money.length ==  1) return money[0];
        return Math.max(money[money.length - 1], money[money.length - 2]);
    }
    
    public static void main(String[] args) {
    	int[] nums = {50,1,1,50};
    	System.out.println(rob(nums));
    	int[] nums1 = {50};
    	System.out.println(rob(nums1));
    	int[] nums2 = {1, 50};
    	System.out.println(rob(nums2));
    	int[] nums3 = {1,1, 1, 100, 1};
    	System.out.println(rob(nums3));
    	int[] nums4 = {1,1, 1, 100, 200};
    	System.out.println(rob(nums4));
    }
}