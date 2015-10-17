/*
	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode ans;
        ListNode node;
        if(node1.val <= node2.val){
             ans = new ListNode(node1.val);
             node = ans;
            node1 = node1.next;
        }
        else{
             ans = new ListNode(node2.val);
             node = ans;
            node2 = node2.next;
        }
        while(true){
            if(node1 == null){
                node.next = node2;
                return ans;
            }
            else if(node2 == null){
                node.next = node1;
                return ans;
            }
            else if(node1.val <= node2.val){
                ListNode tmp = new ListNode(node1.val);
                node.next = tmp;
                node = node.next;
                node1 = node1.next;
            }
            else if(node2.val < node1.val){
                ListNode tmp = new ListNode(node2.val);
                node.next = tmp;
                node = node.next;
                node2 = node2.next;
            }
        }
    }
}