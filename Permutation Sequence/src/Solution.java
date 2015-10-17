/*
  	The set [1,2,3,…,n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	Note: Given n will be between 1 and 9 inclusive.
	
	
	Backtracing
	
	


*/
import java.util.*;
public class Solution {
    public static String getPermutation(int n, int k) {
    	List<String> ans = new LinkedList<String>();
    	List<Integer> currentNums = new LinkedList<Integer>();
    	for(int i = 1; i <= n; i++){
    		currentNums.add(i);
    	}
    	String currentString = new String();
    	ans = helper(currentNums, ans, currentString);
    	return ans.get(k - 1);
    }
    
    public static List<String> helper(List<Integer> currentNums, List<String> ans, String currentString){
    	if(currentNums.size() == 1){
    		ans.add(currentString + Integer.toString(currentNums.get(0)));
    		return ans;
    	}
    	else{
    		List<String> newAns = new LinkedList<String>();
    		newAns.addAll(ans);
	    	for(int i = 0; i < currentNums.size(); i++){
	    		List<Integer> newNums = new LinkedList<Integer>();
	    		newNums.addAll(currentNums);
	    		int temp = newNums.get(i);
	    		newNums.remove(i);
	    		String newString = currentString + Integer.toString(temp);
	    		newAns = helper(newNums, ans, newString);
	    	}
	    	return newAns;
    	}
    }
    public static void main(String[] args){
    	System.out.println(getPermutation(5,3));
    }
}