import java.util.Arrays;

/*

	Given an array of size n, find the majority element. 
	The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	
	
	sort
	loop and count the number
*/

public class Solution {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int curr = nums[0];
        int counter = 1;
        System.out.println(nums.length / 2);
        for(int i = 1; i < nums.length; i++){
        	if(counter > (nums.length / 2)) return curr;
        	if(nums[i] != curr){
        		curr = nums[i];
        		counter = 1;
        	}
        	else{
        		counter++;
        	}
        }
        return curr;
    }
    
    public static void main(String[] args){
    	int[] nums = {-1,1,1,1,2,1};
    	System.out.println(majorityElement(nums));
    }
}