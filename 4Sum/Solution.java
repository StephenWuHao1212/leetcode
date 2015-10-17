/*
	Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
	The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>(); 
        int len = nums.length;
        if(len < 4) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){
            if(i == 0 || nums[i] > nums[i - 1]){
                for(int j = i + 1; j < len - 2; j++){
                    if(j == i + 1 || nums[j] > nums[j - 1]){
                        int tar = target - nums[i] - nums[j];
                        int start = j + 1; int end = len - 1;
                        while(true){
                            if(start >= end) break;
                            else if(tar == nums[start] + nums[end]){
                                List<Integer> tmp = new LinkedList<Integer>();
                                tmp.add(nums[i]); tmp.add(nums[j]); tmp.add(nums[start]); tmp.add(nums[end]);
                                ans.add(tmp);
                                end--; start++;
                                while(start < end && nums[start] == nums[start - 1]) start++;
                                while(start < end && nums[end] == nums[end + 1]) end--;
                            }
                            else if(tar > nums[start] + nums[end]){
                                start++;
                            }
                            else if(tar < nums[start] + nums[end]){
                                end--;
                            }
                            
                        }
                    }
                }
            }
        }
        return ans;
    }
}