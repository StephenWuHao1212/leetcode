import java.util.Arrays;

/*

	Given an array of integers, find two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	 Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
	
	
	
	sort the array first, then use two pointer, one from the first index and the other one starts from the end
	if p1 + p2 == target, return p1, p2
	if p1 + p2 < target, p1++
	if p2 + p2 > target, p2--
*/

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
    	int[] num = nums.clone();
    	Arrays.sort(nums);
    	int p1 = 0;
    	int p2 = nums.length - 1;
    	int tmp = 0;
    	while(true){
    		tmp = nums[p1] + nums[p2];
    		if(tmp == target){
    			int[] ans = new int[2];
    			int j = 0;
    			for(int i = 0; i < num.length; i++){
    				if(num[i] == nums[p1] || num[i] == nums[p2]) {
    					ans[j] = i + 1;
    					j++;
    				}
    			}
    			return ans;
    		}
    		else if(tmp < target) p1++;
    		else p2--;
    	}
    }
    
    public static void main(String[] args){
    	int[] nums = {1,4,3,2,8,30};
    	System.out.println(twoSum(nums,7));
    	System.out.println(twoSum(nums,31));
    	System.out.println(twoSum(nums,9));
    	System.out.println(twoSum(nums,5));
    }
}
