/*

	Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?


	fast and slow pointer to get the middle of the linkedlist
	reverse the second part
	compare these two part and determine if it is a Palindrome

 */





public class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = slow;
		if(second.next != null){
			ListNode p1 = null;
			ListNode p2 = second;
			ListNode p3 = second.next;
			while(p3 != null) {
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				p3 = p3.next;
			}
			p2.next = p1;
			second = p2;
		}
		ListNode curr1 = head;
		ListNode curr2 = second;
		while(curr1 != slow) {
			if(curr1.val != curr2.val) return false;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return true;
	}
}