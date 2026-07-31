class MinStack {
    Deque<Integer> dq;

    public MinStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        dq.offerLast(val);
    }
    
    public void pop() {
        dq.pollLast();       
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public int getMin() {
        Integer m = Integer.MAX_VALUE;
        Iterator<Integer> it = dq.iterator();
        while(it.hasNext()) {
            int num = it.next();
            m = Math.min(m, num);
        }
        return m;
    }
}
