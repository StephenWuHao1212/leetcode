/*
	Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public class set{
        int val;
        int index;
        public set(int value, int indexIn){
            val = value;
            index = indexIn;
        }
    }
    
    class intComparator implements Comparator<set>{
        public int compare(set a, set b){
            return a.val - b.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        if(len == 1) return lists[0];
        ListNode[] curr = lists;
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        LinkedList<set> list = new LinkedList<set>();
        for(int i = 0; i < len; i++){
            if(curr[i] != null){
                set tmp = new set(curr[i].val, i);
                list.add(tmp);
                curr[i] = curr[i].next;
            }
        }
        if(list.isEmpty()) return lists[0];
        Collections.sort(list, new intComparator());
        while(true){
            if(list.size() == 1){
                ListNode smallest = new ListNode(list.peek().val);
                node.next = smallest;
                if(curr[list.peek().index] != null)
                    node.next.next = curr[list.peek().index];
                return ans.next;
            }
            ListNode smallest = new ListNode(list.peek().val);
            node.next = smallest;
            node = node.next;
            int i = list.peek().index;
            list.pop();
            if(curr[i] != null){
                set newSet = new set(curr[i].val, i);
                list.add(newSet);
                curr[i] = curr[i].next;
                Collections.sort(list, new intComparator());
            }
        }
        
    }
}