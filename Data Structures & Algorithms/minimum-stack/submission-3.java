class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        minStack.push(min);
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.empty() ? Integer.MAX_VALUE : minStack.peek(); 
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
