/*

	Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	(ie, from left to right, level by level from leaf to root).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]


	Solution:

	one queue q to store traversed tree node, add the root into the queue
	one linkedlist l to store the level of the tree
	if treeNode is null, return l
	maxNumber represent the maximum number of items of one level
	currentNumber represent the 
	nullCounter represent the number of null pointers in current level
	when q is not empty, 
		- pop one out of the q
		- currentNumber++
		- if null
			- nullCounter++
		- else
			- add left and right into the q
			- add the q value into the level list
		- if currentNumber reaches the maxNumber, update level
			- maxNumber = maxNumber * 2 - nullCounter * 2
			- currentNumber = 0
			- add the level list into l;
			- refresh level list
			- nullCounter = 0
	one likedlist ans to store the final result
	from the end of l, pop and add items into ans until l is empty
	return ans


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
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<List<Integer>> l = new LinkedList<List<Integer>>();
		if(root == null) return l;
		int maxNumber = 1;
		int currentNumber = 0;
		int nullCounter = 0;
		List<Integer> list = new LinkedList<Integer>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			currentNumber++;
			if(node == null){
				nullCounter++;
			}
			else{
				q.add(node.left);
				q.add(node.right);
				list.add(node.val);
			}
			if(currentNumber == maxNumber){
				if(!list.isEmpty()){
					l.add(list);
				}
				list = new LinkedList<Integer>();
				currentNumber = 0;
				maxNumber = maxNumber * 2 - nullCounter * 2;
				nullCounter = 0;
			}
		}
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		while(!l.isEmpty()){
			ans.add(l.pollLast());
		}
		return ans;

	}

	public static void main(String args[]){

		TreeNode t = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		t.left = left;
		t.right = right;
		List<List<Integer>> test = levelOrderBottom(t);
		System.out.println(test);
	}
}




















