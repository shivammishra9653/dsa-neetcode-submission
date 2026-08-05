class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                int num1 = st.pop();
                int num2 = st.pop();
                int num = num1+num2;
                st.push(num);
            } else if (tokens[i].equals("-")) {
                int num1 = st.pop();
                int num2 = st.pop();
                int num = num2 - num1;
                st.push(num);
            } else if(tokens[i].equals("*")) {
                int num1 = st.pop();
                int num2 = st.pop();
                int num = num1*num2;
                st.push(num);
            } else if(tokens[i].equals("/")) {
                int num1 = st.pop();
                int num2 = st.pop();
                int num = num2/num1;
                st.push(num);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
