/*
	Given an array of integers, find if the array contains any duplicates.
	Your function should return true if any value appears at least twice in the array, 
	and it should return false if every element is distinct.


	
	use hashset: faster than hashtable
*/


import java.util.*;
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
    	  if(nums==null || nums.length==0)
    	        return false;
    	 
    	    HashSet<Integer> set = new HashSet<Integer>();
    	    for(int i: nums){
    	        if(!set.add(i)){
    	            return true;
    	        }
    	    }
    	 
    	    return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1};
    	System.out.println(containsDuplicate(nums));
    }
}