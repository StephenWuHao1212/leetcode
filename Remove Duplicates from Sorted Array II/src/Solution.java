/*
	Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?

	For example,
	Given sorted array nums = [1,1,1,2,2,3],

	Your function should return length = 5, with the 
	first five elements of nums being 1, 1, 2, 2 and 3. 
	It doesn't matter what you leave beyond the new length.



	Two Pointers
 */



public class Solution {
	public static int removeDuplicates(int[] nums) {
		if(nums.length < 3) return 2; 
		int ans = -1;
		int count = 0;
		int curr = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == curr){
				count++;
				if(count < 3){
					ans++;
					nums[ans] = curr;
				}
			}
			else{
				count = 1;
				curr = nums[i];
				ans++;
				nums[ans] = curr;
			}
		}
		return ans + 1;
	}
	
	public static void main(String[] args){
		int[] nums = {1,1,1,1,2,3};
		System.out.println(removeDuplicates(nums));
	}
}