/*
	Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5



	walk through the linkedlist and delete the node with the value
	fake header
 */



public class Solution {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode curr = h;
		while(curr != null && curr.next != null) {
			if(curr.next.val == val){
				curr.next = curr.next.next;
			}
			else curr = curr.next;
		}
		return h.next;
	}
}