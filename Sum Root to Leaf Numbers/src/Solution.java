/*
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

	An example is the root-to-leaf path 1->2->3 which represents the number 123.

	Find the total sum of all root-to-leaf numbers.

	For example,

	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25.

 */



public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}
	
	public static int helper(TreeNode node, int curr){
		if(node == null) return 0;
		int nextCurr = curr*10 + node.val;
		if(node.left == null && node.right == null) return nextCurr;
		return helper(node.left, nextCurr) + helper(node.right, nextCurr);
		
	}
}