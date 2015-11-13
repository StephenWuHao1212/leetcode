/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is 
LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


DFS,

	TreeNode helper(TreeNode node, TreeNode p, TreeNode q)
		- if node = null, return null
		- if node == p or node == q
			return node
		- left = helper(node.left, p, q)
		- right = helper(node.right, p, q)
		- if(left != null && right != null)
			return node
		- else if(left != null) return left
		- else if(right != null) return right
		- else return null 
 */


public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		return helper(root, p, q);
	}
	
	public static TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
		if(node == null) return null;
		if(node == p || node == q) return node;
		TreeNode left = helper(node.left, p, q);
		TreeNode right = helper(node.right, p, q);
		if(left != null && right != null) return node;
		else if(left != null) return left;
		else if(right != null) return right;
		else return null;
	}
}