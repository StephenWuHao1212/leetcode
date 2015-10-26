/*
	Given a sorted linked list, delete all duplicates such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
*/


/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/*
 * 
 * loop to check if there is duplicate. if it is the first node of duplicate, skip the first node
 * 
 */
public class Solution {
	public static class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        int currentVal = head.val;
        ListNode currentNode = head.next;
        ListNode lastNode = head;
        while(currentNode != null) {
        	if(currentNode.val != currentVal){
        		currentVal = currentNode.val;
        		lastNode = currentNode;
        		currentNode = currentNode.next;
        	}
        	else{
        		lastNode.next = currentNode.next;
        		currentNode = currentNode.next;
        	}
        }
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(1);
    	ListNode node4 = new ListNode(1);
    	ListNode node5 = new ListNode(3);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = null;
    	
    	ListNode newNode = deleteDuplicates(node1);
    	ListNode curr = newNode;
    	while(curr != null){
    		System.out.println(curr.val);
    		curr = curr.next;
    	}



    	
    }
}











