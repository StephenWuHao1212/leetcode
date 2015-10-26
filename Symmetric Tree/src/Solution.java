/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

Break the tree to two parts from the second layer, then recursively determine
if node1.left equals to node2.right and if node1.right equals to node2.left
	helper(node p, node q)
		- p, q are null, return true
		- just one of them is null, return false
		- they dont have same value, return false
		- return helper(p.left, q.right) && helper(p.right, q.left)
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
    public static boolean isSymmetric(TreeNode root) {
    	return helper(root.left, root.right);
    }
    
    public static boolean helper(TreeNode p, TreeNode q){
    	if(p == null && q == null) return true;
    	if((p == null && q != null) || (p != null && q == null)) return false;
    	if(p.val != q.val) return false;
    	return helper(p.left, q.right) && helper(p.right, q. left);
    }
}