/*


	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
	v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      _4       7       9
	         /  \
	         3   5

	For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
	since a node can be a descendant of itself according to the LCA definition.




	that is a BST, can apply the range to simplify the process
	
	TreeNode helper(TreeNode node, TreeNode p, TreeNode q)
		- if node is null return null
		
		- TreeNode left = null
		- TreeNode right = null
		- if node > p and > q
			left = helper(node.left, p, q)
		- else if node < p and < q
			right = helper(node.right, p, q)
		- else if node > min and node < max
			left = helper(node.left, p, q)
			right = helper(node.right, p, q)
		- else if node == q or  node == p
			left = node
	
		- if left is null and right is not null
			
			return right
		- if left is not null and right is null
			
			return left
		- if left is not null and right is not null
			return node
		- if left is null and right is null
			return null


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

	public static TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {

		if(node == null) return null;
		TreeNode left = null;
		TreeNode right = null;
		if(node.val > Math.max(p.val, q.val))
			left = helper(node.left, p, q);
		else if(node.val < Math.min(p.val, q.val))
			right = helper(node.right, p, q);
		else if(node == q || node == p)
			left = node;
		else{
			left = helper(node.left, p, q);
			right = helper(node.right, p, q);
		}
		
		if(left == null && right != null) return right;
		if(left != null && right == null) return left;
		if(left != null && right != null) return node;
		if(left == null && right == null) return null;
		return null;
	}
}