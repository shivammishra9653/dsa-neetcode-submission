class Solution {
    // TC = O(n^2), SC = O(1) ignoring the space occupied by the input array.
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length - 1; i++) {
            for(int j = i+1; j < heights.length; j++) {
                max = Math.max(max, Math.min(heights[i], heights[j])*(j-i));
            }
        }
        return max;
    }
}
