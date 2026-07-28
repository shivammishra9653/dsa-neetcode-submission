class Solution {
    // TC = O(n^2), SC = O(1) ignoring the space occupied by input array
    public int trap(int[] height) {

        int res = 0;

        for(int i = 1; i < height.length - 1; i++) {
            int lmax = height[i];
            for(int j = 0; j < i; j++) {
                lmax = Math.max(lmax, height[j]);
            }

            int rmax = height[i];
            for(int k = i+1; k < height.length; k++) {
                rmax = Math.max(rmax, height[k]);
            }
            res += (Math.min(lmax, rmax) - height[i]);
        }
        return res;
        
    }
}
