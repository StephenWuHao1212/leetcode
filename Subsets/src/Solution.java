/*
	Given a set of distinct integers, nums, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:

	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]

	Solution: backtracing
	sort the nums array to be in non-descending order
	helper(List currentList, List remainingNumbers, List<List> ans)
		- if the remainingNumbers is empty.
			- add the currentList to ans
			- return
		- add the first number from the remainingNumbers to the currentList
		- remove that number from the remainingNumber list
		- helper(cuurentList, remainingNumbers, ans)
 */
import java.util.*;
public class Solution {
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		LinkedList<Integer> remainingNumbers = new LinkedList<Integer>();
		for(int i:nums) {
			remainingNumbers.add(i);
		}
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		LinkedList<Integer> currentList = new LinkedList<Integer>();
		helper(currentList, remainingNumbers, ans);
		return ans;

	}
	public static void helper(LinkedList<Integer> currentList, LinkedList<Integer> remainingNumbers, List<List<Integer>> ans){
		if(remainingNumbers.isEmpty()){
			if(!currentList.isEmpty()){
				ans.add(currentList);
			}
			return;
		}
		int length = remainingNumbers.size();
		LinkedList<Integer> newRemainingNumbers = new LinkedList<Integer>();
		newRemainingNumbers.addAll(remainingNumbers);
		for(int i = 0; i <= length; i++){
			LinkedList<Integer> newCurrentList = new LinkedList<Integer>();
			newCurrentList.addAll(currentList);	
			if(!newRemainingNumbers.isEmpty()){
				newCurrentList.add(newRemainingNumbers.getFirst());
				newRemainingNumbers.removeFirst();
			}
			helper(newCurrentList, newRemainingNumbers, ans);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(subsets(nums));
	}
}