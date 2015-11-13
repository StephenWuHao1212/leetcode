/*
	Reverse a singly linked list.


	a linked list 
		a -> b -> c-> d -> e
	3 pointer 
		first points to null
		second points to a
		third points to b 

		second.next = first
		first = second
		second = third
		third = third.next
		if third == null
			return second
 */

public class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p1 = null;
		ListNode p2 = head;
		ListNode p3 = head.next;

		while(p3 != null){
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
		}
		p2.next = p1;
		return p2;
	}
}