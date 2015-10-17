public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        if(nums1.length == 0) return helper(nums2);
        else if(nums2.length == 0)  return helper(nums1);
        else{
            int[] combined = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, combined, 0, nums1.length);
            System.arraycopy(nums2, 0, combined, nums1.length, nums2.length);
            return helper(combined);
        }
     
    }
    public double helper(int[] nums){
        Arrays.sort(nums);
        if(nums.length % 2 == 0){
            int a = nums[nums.length / 2];
            int b = nums[(nums.length / 2) - 1];
            double ans = (double)(a + b) / 2;
            return ans;
        }            
        else{
            int a = nums.length / 2;
            return (double)nums[a];
        } 
    }
}