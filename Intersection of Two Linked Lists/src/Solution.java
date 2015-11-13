/*

	Write a program to find the node at which the intersection of two singly linked lists begins.


	For example, the following two linked lists:

	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
	begin to intersect at node c1.


	Notes:

	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.


 */

public class Solution{

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	//first method, calculate the length of two list first, then make them to be the same length
	//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	//		if(headA != null && headB != null){
	//			ListNode curr = headA;
	//			int lengthA = 0;
	//			while(curr != null){
	//				lengthA++;
	//				curr = curr.next;
	//			}
	//			curr = headB;
	//			int lengthB = 0;
	//			while(curr != null){
	//				lengthB++;
	//				curr = curr.next;
	//			}
	//			int lmin = Math.min(lengthA, lengthB);
	//			ListNode currA = headA;
	//			ListNode currB = headB;
	//			while(lengthA > lmin){
	//				currA = currA.next;
	//				lengthA--;
	//			}
	//			while(lengthB > lmin){
	//				currB = currB.next;
	//				lengthB--;
	//			}
	//			while(lmin > 0) {
	//				if(currA.val == currB.val) return currA;
	//				currA = currA.next;
	//				currB = currB.next;
	//				lmin--;
	//			}
	//
	//		}
	//		return null;
	//	}


	//second one, two pointers, if PA reaches the end, redirect it to the head of B, vice versa 
	//some time they will reach the same node or one of them will get back the head if no intersection
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode pa = headA;
		ListNode pb = headB;
		boolean isInA = true;
		boolean isInB = true;
		boolean stop = false;
		while(true){
			if(pa == pb) return pa;
			pa = pa.next;
			pb = pb.next;
			if(pa == null){
				if(isInA) pa = headB;
				else stop = true;
				isInA = !isInA;
			}
			if(pb == null){
				if(isInB) pb = headA;
				else stop = true;
				isInB = !isInB;
			}
			if(stop) return null;

		}
	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		System.out.println(getIntersectionNode(node2, node1).val);
	}

}