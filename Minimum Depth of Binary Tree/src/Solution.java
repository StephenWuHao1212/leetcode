/*
	Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the 
	shortest path from the root node down to the nearest leaf node.


	breadth first search, the depth of first node with left null and right null will be the shortest 
	path

	if root is null, return 0
	queue to store traversal node
	add root into the queue
	maxNumber to represent the max number of nodes in that level
	currentNumber to represent the number of current traversaled nodes
	nullCounter to represent the number of null nodes in the current level
	currentDepth to represent the current level of depth
	when q is not empty
		- pop a node
		- currentNumber++
		- if node is null
			- nullCounter++
		- else if left node and right node are null, return currentDepth
		- else 
			- add left node and right node to queue
		- if currentNumber equals to maxNumber
			- refresh the status of the tree
			- currentNumber = 0
			- maxNumber = (maxNumber - nullCounter) * 2
			- currentDepth++
			- nullCounter = 0
	return currentDepth
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

import java.util.*;
public class Solution {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int maxNumber = 1;
		int currentNumber = 0;
		int nullCounter = 0;
		int currentDepth = 1;
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			currentNumber++;
			if(node == null){
				nullCounter++;
			}		
			else if(node.left == null && node.right == null) return currentDepth;
			else{
				q.add(node.left);
				q.add(node.right);
			}
			if(currentNumber == maxNumber) {
				currentNumber = 0;
				maxNumber = (maxNumber - nullCounter) * 2;
				currentDepth++;
				nullCounter = 0;
			}
		}
		return currentDepth;
	}
}















