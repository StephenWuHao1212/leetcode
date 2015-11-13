/*

	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.



	two pointers. 
	get all the non-zero num first and then add zero to the end of the array
	

*/



public class Solution {
    public static void moveZeroes(int[] nums) {
    	 int count = 0;  
         for (int i = 0; i < nums.length; i++){
             if (nums[i] != 0){
                 nums[count++] = nums[i];
             }
         }
         while (count < nums.length)
             nums[count++] = 0;
    }
    
    public static String printNums(int[] nums){
    	String ans = "";
    	for(int i = 0; i < nums.length; i++){
    		ans += nums[i];
    	}
    	return ans;
    }

    public static void main(String[] args){
    	int[] nums = {1,2,3,4};
    	moveZeroes(nums);
    	System.out.println(printNums(nums));
    	
    	int[] nums1 = {1};
    	moveZeroes(nums1);
    	System.out.println(printNums(nums1));
    	
    	int[] nums2 = {0};
    	moveZeroes(nums2);
    	System.out.println(printNums(nums2));
    	
    	int[] nums3 = {0,0,0,0};
    	moveZeroes(nums3);
    	System.out.println(printNums(nums3));
    	
    	int[] nums4 = {0,2,1,3,3};
    	moveZeroes(nums4);
    	System.out.println(printNums(nums4));
    	
    	int[] nums5 = {};
    	moveZeroes(nums5);
    	System.out.println(printNums(nums5));
    	
    	int[] nums6 = {2,1,0,0,0,3,0,3,3};
    	moveZeroes(nums6);
    	System.out.println(printNums(nums6));
    	
    	int[] nums7 = {2,1,0,0,2};
    	moveZeroes(nums7);
    	System.out.println(printNums(nums7));
    	
    	int[] nums8 = {2,1,0,0,3,3,3};
    	moveZeroes(nums8);
    	System.out.println(printNums(nums8));
    	
    	int[] nums9 = {2,1,0,0,3,3};
    	moveZeroes(nums9);
    	System.out.println(printNums(nums9));
    }
}