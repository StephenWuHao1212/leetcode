/*
	Given a linked list, remove the nth node from the end of list and return its head.

	For example,

   	Given linked list: 1->2->3->4->5, and n = 2.

   	After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        if(len == 1){
            return null;
        }
        if(n == len){
            return head.next;
        }
        else{
            int count = 0;
            node = head;
            while(node != null){
                if(count == len - n - 1){
                    node.next = node.next.next;
                    break;
                }
                else{
                    node = node.next;
                    count++;
                }
            }
        }
        return head;
    }
}