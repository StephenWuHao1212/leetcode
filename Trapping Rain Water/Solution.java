/*
	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length < 2) return result;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int length = height.length;
        int max = height[0];
        left[0] = max;
        for(int i = 1; i < length; i++){
            left[i] = Math.max(height[i], max);
            max = Math.max(height[i], max);
        }
        
        max = height[length - 1];
        right[length - 1] = max;
        for(int i = length -2; i >= 0; i--){
            right[i] = Math.max(height[i], max);
            max = Math.max(height[i], max);
        }
        
        for(int i = 0; i < length; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}