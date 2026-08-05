class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!st.empty() && st.peek()[0] <= temperatures[i]) {
                st.pop();
            }
            if(!st.empty()) {
                res[i] = st.peek()[1] - i;
            }
            st.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
