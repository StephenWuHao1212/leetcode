/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


int helper(TreeNode node, int currentDepth) {
	if node is null
		return currentDepth
	currentDepth++
	leftDepth = helper(node.left, currentDepth)
	rightDepth = helper(node.right, currentDepth)
	if leftDepth or rightDepth equals to -1
		return -1 
	else if abs(leftDepth - rightDepth > 1)
		return -1
	else
		return max(leftDepth, rightDepth)
}

root calls the helper, if helper returns -1, means that the two subtree is not balanced
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isBalanced(TreeNode root) {
		if(helper(root, 0) == -1) return false;
		return true;
	}

	public int helper(TreeNode node, int currentDepth){
		if(node == null) return currentDepth;
		currentDepth++;
		int leftDepth = helper(node.left, currentDepth);
		if(leftDepth == -1) return -1;
		int rightDepth = helper(node.right, currentDepth);
		if(rightDepth == -1) return -1;
		if(Math.abs(leftDepth - rightDepth) > 1) return -1;
		return Math.max(leftDepth, rightDepth);
	}
}