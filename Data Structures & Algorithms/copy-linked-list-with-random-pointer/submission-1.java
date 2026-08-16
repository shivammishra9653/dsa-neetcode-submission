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
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        // create all copy node
        while(temp != null) {
            Node copy = new Node(temp.val);
            map.put(temp, copy);
            temp = temp.next;
        }

        // connect next and random
        temp = head;
        while(temp != null) {
            Node temp1 = map.get(temp); // copyNode
            Node temp2 = temp.next;
            temp1.next = map.get(temp2);
            // if(temp.random != null) {
            //     temp1.random = map.get(temp.random);
            // }
            temp1.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
