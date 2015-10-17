/*
	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

	If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

	You may not alter the values in the nodes, only nodes itself may be changed.

	Only constant memory is allowed.

	For example,
	Given this linked list: 1->2->3->4->5

	For k = 2, you should return: 2->1->4->3->5

	For k = 3, you should return: 3->2->1->4->5
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
   public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        if(k < 2) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode start = sentinel;
        ListNode end = sentinel;
        ListNode[] array = new ListNode[k];
        while(true){
            for(int i = 0; i < k; i++){
                if(end.next == null) return sentinel.next;
                else{
                    end = end.next;
                    array[i] = end;
                }
            }
            end = end.next;
            for(int i = array.length - 1; i >=0; i--){
                start.next = array[i];
                start = start.next;
            }
            start.next = end;
            end = start;
        }
   }
}  