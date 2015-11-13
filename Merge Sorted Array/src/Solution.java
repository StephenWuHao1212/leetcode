/*
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
	additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

 */
public class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while(true){
			if(j >= 0 && i >= 0){
				if(nums1[i] > nums2[j]){
					nums1[k] = nums1[i];
					k--;i--;
				}
				else{
					nums1[k] = nums2[j];
					k--;j--;
				}
			}
			else if(j < 0) return;
			else if(i < 0) {
				for(;j >= 0; j--,k--){
					nums1[k] = nums2[j];
				}
				return;
			}
		}
	}




	public static void main(String[] args){
		int[] a = {1};
		int[] b = {2};
		int[] test = merge(a, b);
		System.out.println("test");

		for(int i = 0; i < test.length; i++){
			System.out.println(test[i]);
		}
	}



}