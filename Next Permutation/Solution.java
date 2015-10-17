/*
	Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	The replacement must be in-place, do not allocate extra memory.

	Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int lenOfNums = nums.length;
	    if(lenOfNums < 2) return;
	    int i = lenOfNums - 1;
	    for(;i > 0; i--){
	    	 if(nums[i] > nums[i - 1]){
				for(int j = lenOfNums - 1; j > i - 1; j--){
					if(nums[j] > nums[i - 1]){
						int temp = nums[i - 1];
						nums[i - 1] = nums[j];
						nums[j] = temp;
						break;
					}
				}
				break;
			 }
		 }
		 for(int k = 0; k <  (lenOfNums - i + 1) / 2; k++){
			 int temp = nums[i + k];
			 nums[i + k] = nums[lenOfNums - 1 - k];
			 nums[lenOfNums - 1 - k] = temp;
		 }
    }
}