/*
	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


	breath-first-search


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
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, 0);
    }
    
    public boolean helper(TreeNode node, int sum, int currentSum){
        if(node == null) return false;
        currentSum += node.val;
    	if(node.left == null && node.right == null){
    		if(sum == currentSum) return true;
    		else return false;
    	}
    	return helper(node.left, sum, currentSum) || helper(node.right,sum, currentSum);
    }
}