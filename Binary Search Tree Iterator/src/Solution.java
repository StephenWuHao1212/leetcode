/*

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.



stack
 */


import java.util.*;
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public BSTIterator(TreeNode root) {
		while(root != null){
			stack.add(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		int ans = node.val;
		node = node.right;
		while(node != null){
			stack.push(node);
			node = node.left;
		}
		return ans;
	}
}
