/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            list.add(curr);
            next = curr.next;
            curr.next = null;
            curr = next;
        }
        ListNode dummy = new ListNode(0);
        curr = dummy;
        int i = 0;
        int j = list.size() - 1;
        while(i <= j) {
            if(i == j) {
                curr.next = list.get(i);
            } else {
                curr.next = list.get(i);
            curr.next.next = list.get(j);
            curr = curr.next.next;
            }
            
            i++; j--;
        }
        head = dummy.next;
        
    }
}
