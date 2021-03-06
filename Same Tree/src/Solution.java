/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 *  set a helper function to recuresively solve this problem
 *  depth-first search
 *  two nodes: node1 represents tree1, node2 represents tree2
 *  - if two nodes are null, return true
 *  - if two node is not the same, return false
 *  - if one is null and the other one is not null, return false
 *  - return helper(node1.left, node2.left) && helper(node1.right, node2.right)
 */

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		return helper(p, q);
	}
	
	public static boolean helper(TreeNode p, TreeNode q){
		if(p == null && q == null) return true;
		if((p == null && q != null) || (p != null) && (q == null)) return false;
		if(p.val != q.val) return false;
		return helper(p.left, q.left) && helper(p.right, q.right);
	}
	
}