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
    public ListNode getKth(ListNode curr, int k) {
        while(curr != null && k-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0, head);
       ListNode prevGroup = dummy;

       while(true) {
        ListNode kth = getKth(prevGroup, k);
        if(kth == null) {
            break;
        }
        ListNode prev = null;
        ListNode curr = prevGroup.next;
        ListNode groupNext = kth.next;
        while(curr != groupNext) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        prevGroup.next.next = groupNext;
        ListNode temp = prevGroup.next;
        prevGroup.next = prev;
        prevGroup = temp;
       }
       return dummy.next;
    }
}
