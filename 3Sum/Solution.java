/*
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

	Note:
	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
	The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length < 3) return ans;
        Arrays.sort(nums);
        int i = 0; 
        while(i <= nums.length - 3){
            int diff = -nums[i];
            int start = i + 1; 
            int end = nums.length - 1;
            while(true){
                if(start >= end) break;
                if(nums[start] + nums[end] > diff){ 
                        end -= 1;
                }
                else if(nums[start] + nums[end] < diff) {
                        start += 1;
                }
                else{
                    List<Integer> curr = new ArrayList<Integer>();
                    curr.add(nums[i]); curr.add(nums[start]); curr.add(nums[end]);
                    ans.add(curr);
                    int tmp = nums[start];
                    while(end > start && nums[start] == tmp)
                        start += 1;
                    tmp = nums[end];
                    while(end > start && nums[end] == tmp)
                        end -= 1;
                }
            }
            int tmp = nums[i];
            while(nums[i] == tmp && i <= nums.length -3) i++;
        }
        return ans;
        
    }
}