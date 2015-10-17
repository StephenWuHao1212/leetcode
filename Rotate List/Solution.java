/*
	Given a list, rotate the list to the right by k places, where k is non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
*/	

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k < 0) return null;
        if(k == 0 || head == null) return head;
        ListNode currentNode = head;
        int length = 1;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            length++;
        }
        ListNode tail = currentNode;
        int index = k % length;
        currentNode = head;
        for(int i = 0; i < length - index - 1; i++){
            currentNode = currentNode.next;
        }
        tail.next = head;
        head = currentNode.next;
        currentNode.next = null;
        return head;
    }
}