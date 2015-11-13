/*

	Given a binary tree, return all root-to-leaf paths.

	For example, given the following binary tree:

	   1
	 /   \
	2     3
	 \
	  5
	All root-to-leaf paths are:

	["1->2->5", "1->3"]

	helper(TreeNode node, List<int> temp, List<String> ans)
		- if node is null,
			- return
		- if node.left and node.right are null
			- add node.val into temp
			- construct the string representation of temp
			- add the representation to ans
		- else
			- helper(node.left,temp, ans)
			- helper(node.right, temp, ans)

 */



import java.util.*;
public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		LinkedList<String> ans = new LinkedList<String>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp.add(root.val);
		helper(root, temp, ans);
		return ans;
	}
	
	public static void helper(TreeNode node, LinkedList<Integer> temp, LinkedList<String> ans){
		if(node == null) return;
		
		if(node.left == null && node.right == null){
			String ansString = "";
			LinkedList<Integer> s = new LinkedList<Integer>();
			s.addAll(temp);
			while(!s.isEmpty() ){
				ansString += s.poll().toString() + "->";
				
			}
			ansString += node.val;
			ans.add(ansString);
		}
		else{
			LinkedList<Integer> s = new LinkedList<Integer>();
			s.addAll(temp);			
			helper(node.right, s, ans);
			LinkedList<Integer> t = new LinkedList<Integer>();
			t.addAll(temp);	
			helper(node.left, t, ans);
		}
	}
}

















