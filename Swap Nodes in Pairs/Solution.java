/*
	Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode node = curr;
        while(true){
            if(node.next == null) return curr.next;
            if(node.next.next == null) return curr.next;
            ListNode temp = new ListNode(node.next.val);
            temp.next = node.next.next.next;
            node.next.next.next = temp;
            node.next = node.next.next;
            node = node.next.next;
        }
    }
}