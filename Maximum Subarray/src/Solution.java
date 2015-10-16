/* 

    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    
    Dynamic Programming
    ignore the previous n - 1 elements if the nth element is greater than the
    sum of the previous n - 1 elements + the nth element
   
 */
import java.util.*;
public class Solution {
    public static int maxSubArray(int[] nums) {
    	int ans = nums[0];
    	int previousSum = nums[0];
    	for(int i = 1; i < nums.length; i++){
    		previousSum = Math.max(nums[i], previousSum + nums[i]);
    		ans = Math.max(previousSum, ans);
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	System.out.println(maxSubArray(nums)); 
    }
    
}
