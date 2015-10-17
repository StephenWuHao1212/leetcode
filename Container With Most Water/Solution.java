/*
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2) return 0;
        int i; int j;
        int ans = 0;
        for(i = 0, j = height.length -1; i < j;){
            int area = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(area, ans);
            if(height[i] < height[j]) i++;
            else if(height[i] > height[j]) j--;
            else{
                i++; j--;
            }
        }
        return ans;
    }
}