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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        int count = n;
        while(count-- > 0) {
            j = j.next;
        }
        if(j == null) {
            return i.next;
        }
        while(j.next != null) {
            i = i.next;
            j= j.next;
        }
        i.next = i.next.next;
        return head;
    }
}
