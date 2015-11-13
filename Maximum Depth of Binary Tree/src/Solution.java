/*
	Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along 
	the longest path from the root node down to the farthest leaf node.
	
	recursion, return the maximum depth of left node path and the right node path
	helper(node, depth)
		- if node is null, return depth
		- else return max(helper(node.left, depth + 1), helper(node.right, depth + 1))
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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return helper(root, depth);
    }
    
    public int helper(TreeNode node, int depth) {
    	if(node == null) return depth;
    	return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));
    }
}