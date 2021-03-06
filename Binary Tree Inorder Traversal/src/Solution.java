import java.util.*;

/*

	Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].

	Note: Recursive solution is trivial, could you do it iteratively?

  Definition of Inorder Traversal:
  Process all nodes of a tree by recursively processing the left subtree,
  then processing the root, and finally the right subtree.

  Solution:
  - one stack to store the current processed node
  - keep going to left until null and push every value into the stack
  - need to keep track of the current node
  - when keep going left and reach null, pop one node from the stack to represent the
  	left node
  - pop one more to represent the middle node and change the current node to the
   	right node of the popped node
  - if current node is null, pop one more and change the current node to the right node
  	of the popped node, and push the new current node into the stack
  - while current node is null, end the process
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
//	  - one stack to store the current processed node
//	  - keep going to left until null and push every value into the stack
//	  - need to keep track of the current node
//	  - when keep going left and reach null, pop one node from the stack to represent the
//	  	left node
//	  - change the current node to the right node of the popped node
//	  - if current node is null, pop one more and change the current node to the right node
//	  	of the popped node, and push the new current node into the stack
//	  - while current node is null, end the process
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> ans = new LinkedList<Integer>();
		TreeNode currentNode = root;
		while(currentNode != null){
			stack.push(currentNode);
			while(currentNode.left != null){
				currentNode = currentNode.left;
				stack.push(currentNode);
			}
			ans.add(stack.peek().val);
			currentNode = stack.pop().right;
			while(currentNode == null){
				if(stack.isEmpty()){
					return ans;
				}
				ans.add(stack.peek().val);
				currentNode = stack.pop().right;
			}
		}
		return ans;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		System.out.println(inorderTraversal(root));
	}
}












