/*
	Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

	For example:
	Given the below binary tree,

	       1
	      / \
	     2   3
	Return 6.
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
    public int maxPathSum(TreeNode root) {
        if(root != null) return findMax(root, root.val)[1];
        return 0;
    }
    
    public int[] findMax(TreeNode node, int currentMax){
        if(node == null){
            int[] ans = {0, currentMax};
            return ans;
        }
        int[] left = findMax(node.left, currentMax);
        int[] right = findMax(node.right, currentMax);
        currentMax = currentMax > left[1] ? currentMax:left[1];
        currentMax = currentMax > right[1] ? currentMax:right[1];
        currentMax = currentMax > (left[0] + node.val) ? currentMax : (left[0] + node.val);
        currentMax = currentMax > (right[0] + node.val) ? currentMax : (right[0] + node.val);
        currentMax = currentMax > (right[0] + left[0] + node.val) ? currentMax : (right[0] + left[0] + node.val);
        int tmp = (left[0] + node.val) > (right[0] + node.val) ? (left[0] + node.val):(right[0] + node.val);
        tmp = node.val > tmp ? node.val:tmp;
        int[] ans = {tmp, currentMax};
        return ans;
    }
}