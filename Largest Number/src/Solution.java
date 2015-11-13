/*
	Given a list of non negative integers, arrange them such that they form the largest number.

	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	
	Note: The result may be very large, so you need to return a string instead of an integer.

*/
import java.util.*;
public class Solution {
	
	public static Comparator<String> numComparator = new Comparator<String>(){
		public int compare(String a, String b){
			String rightLeft = b + a;
			String leftRight = a + b;
			return -leftRight.compareTo(rightLeft);
		}
	};
	
    public static String largestNumber(int[] nums) {
    	String[] str = new String[nums.length];
    	for(int i =0; i < nums.length; i++){
    		str[i] = String.valueOf(nums[i]);
    	}
    	Arrays.sort(str, numComparator);
    	StringBuilder stringBuilder = new StringBuilder();
    	for(String s:str){
    		stringBuilder.append(s);
    	}
    	while(stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1){
    		stringBuilder.deleteCharAt(0);
    	}
    	return stringBuilder.toString();
    }
    
    public static void main(String[] args){
    	int[] nums = {9,10,22,30,100};
    	System.out.println(largestNumber(nums));
    }
}