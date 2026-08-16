/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void insertCopyInBetween(Node head) {
        Node temp = head;
        while(temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
    }

    public void connectRandom(Node head) {
        Node temp = head;
        while(temp != null) {
            if(temp.random != null) {
            temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }

    public Node getDeepCopy(Node head) {
        Node dummy = new Node(-1);
        Node temp = head;
        Node temp1 = dummy;

        while(temp != null) {
            temp1.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            temp1 = temp1.next;
        }
        return dummy.next;

    }
    public Node copyRandomList(Node head) {
       insertCopyInBetween(head);
       connectRandom(head);
       return getDeepCopy(head);
    }
}
