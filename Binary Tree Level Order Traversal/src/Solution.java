/*
 	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	Create a List<List<Integer>> ans to store the answer
	int maxNumberInList = 1(times two when you reach the maxNumber)
	int currentNumber = 0
	Create an empty queue<TreeNode>
	add root into the queue
	loop until the queue is empty
		- pop one out, if not null, add into the List
		- increment the currentNumber
		- if currentNumber equals to maxNumber
			- add the list to the ans
			- empty the list
			- reset the currentNumber and the maxNumber
		- add node.left and node.right to the queue
		
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

import javax.swing.tree.TreeNode;
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> tempList = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentNumber = 0;
        int nullCounter = 0;
        int maxNumber = 1;
        while(!queue.isEmpty()){
        	TreeNode tempNode = queue.poll();
        	if(tempNode != null) {
        		tempList.add(tempNode.val);
        		queue.add(tempNode.left);
            	queue.add(tempNode.right);
        	}
        	else{
        		nullCounter++;
        	}
        	currentNumber++;
        	if(currentNumber == maxNumber) {
        		ans.add(tempList);
        		tempList = new LinkedList<Integer>();
        		currentNumber = 0;
        		maxNumber = maxNumber * 2 - 2 * nullCounter;
        		nullCounter = 0;
        	}
        }
        return ans;
    }
}








