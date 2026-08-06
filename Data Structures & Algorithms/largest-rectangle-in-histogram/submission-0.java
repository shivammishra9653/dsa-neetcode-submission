class Solution {
    public void prevMin(int[] heights, int[] lmin) {
       Stack<Integer> st = new Stack<>();
        int n = heights.length;
        lmin[0] = -1;
        st.push(0);
        for(int i = 1; i < n; i++) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()) {
                lmin[i] = -1;
            } else {
                lmin[i] = st.peek();
            }
            st.push(i);
        }
    }

    public void nextMin(int[] heights, int[] rmin) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        rmin[n - 1] = n;
        st.push(n-1);
        for(int i = heights.length - 2; i >= 0; i--) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()) {
                rmin[i] = n;
            } else {
                rmin[i] = st.peek();
            }
            st.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int[] lmin = new int[heights.length];
        int[] rmin = new int[heights.length];
       prevMin(heights, lmin);
       nextMin(heights, rmin);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max((rmin[i] - lmin[i] - 1)*heights[i], maxArea);
        }
        return maxArea;
    }
}
