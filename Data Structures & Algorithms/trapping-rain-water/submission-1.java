class Solution {
    // TC = O(n), SC = O(n)
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        for(int i = 0; i < height.length; i++) {
            if(i > 0) {
                lmax[i] = Math.max(lmax[i-1], height[i]);
            } else {
                lmax[i] = height[i];
            }
        }

        for(int j = height.length - 1; j >=  0; j--){
            if(j < height.length - 1) {
                rmax[j] = Math.max(rmax[j+1], height[j]);
            } else {
                rmax[j] = height[j];
            }
        }

        int res = 0;
        for(int i = 1; i < height.length - 1; i++) {
            res += (Math.min(lmax[i], rmax[i]) - height[i]);
        }
        return res;
    }
}
