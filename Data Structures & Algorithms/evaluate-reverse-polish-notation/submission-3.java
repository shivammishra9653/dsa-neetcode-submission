class Solution {
    class DoubleLinkedList {
        String val;
        DoubleLinkedList prev;
        DoubleLinkedList next;

        public DoubleLinkedList(String val, DoubleLinkedList prev, DoubleLinkedList next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    public int evalRPN(String[] tokens) {
        DoubleLinkedList head = new DoubleLinkedList(tokens[0], null, null);
        DoubleLinkedList curr = head;
        for(int i = 1; i < tokens.length; i++) {
            curr.next = new DoubleLinkedList(tokens[i], curr, null);
            curr = curr.next;
        }

        int res = Integer.parseInt(tokens[0]);
        while(head != null) {
            if("+-*/".contains(head.val)) {
                int l = Integer.parseInt(head.prev.prev.val);
                int r = Integer.parseInt(head.prev.val);
                switch(head.val) {
                    case "+":
                       res = l+r;
                       head.val = String.valueOf(res);
                       head.prev = head.prev.prev.prev;
                       break;
                    case "-":
                       res = l-r;
                       head.val = String.valueOf(res);
                       head.prev = head.prev.prev.prev;
                       break;
                    case "*":
                       res = l*r;
                       head.val = String.valueOf(res);
                       head.prev = head.prev.prev.prev;
                       break;
                    case "/":
                       res = l/r;
                       head.val = String.valueOf(res);
                       head.prev = head.prev.prev.prev;
                       break;
                }
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
