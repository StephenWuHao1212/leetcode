import java.util.Arrays;

/*

	Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].





	reverse the first half and the second half, then reverse the whole array
 */


public class Solution {
	public static void rotate(int[] nums, int k) {
		while(k > nums.length){
			k = k % nums.length;
		}
		reverse(nums, 0, nums.length - k -1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public static void reverse(int[] nums, int begin, int end){
		int a = begin;
		int b = end;
		while(a < b){
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
			a++; b--;
		}
	}

	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(nums));
		rotate(nums,2);
	}
}