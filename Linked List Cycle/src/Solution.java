/*
	Given a linked list, determine if it has a cycle in it.


	fast pointer and slow pointer
	if the linked list has a cycle, the fast pointer will somehow be the same as the slow poniter
 */


public class Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		if(head.next == null) return false;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while(true){
			if(slow == null || fast == null) return false;
			if(fast == slow) return true;
			slow = slow.next;
			fast = fast.next;
			if(fast == null) return false;
			fast = fast.next;
		}
	}
}