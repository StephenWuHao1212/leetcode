/*
	Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    public boolean isValidBST(TreeNode root) {
        if(root != null)
            return helper(root, root.val, root.val, false, false);
        else return true;
    }
    
    public boolean helper(TreeNode node, int sLimit, int hLimit, boolean s, boolean h){
        if(node == null) return true;
        boolean sAns = true; boolean hAns = true;
        if(s == true && node.val <= sLimit) sAns = false;
        if(h == true && node.val >= hLimit) hAns = false;
        return sAns && hAns && helper(node.left, sLimit, node.val, s, true) && helper(node.right, node.val, hLimit, true, h);
    }
}