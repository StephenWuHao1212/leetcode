/*


	Given an array of integers and an integer k, find out whether there are 
	two distinct indices i and j in the array such that nums[i] = nums[j] and 
	the difference between i and j is at most k.


	Hashtable
 */

import java.util.*;
public class Solution {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Hashtable<Integer, Integer> t = new Hashtable<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(t.containsKey(nums[i])){
				if(Math.abs(t.get(nums[i]).intValue() - i) <= k) return true;
			}
			t.put(nums[i], i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(containsNearbyDuplicate(nums, 1));
	}
}