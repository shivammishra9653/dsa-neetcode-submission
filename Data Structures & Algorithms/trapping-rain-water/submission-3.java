class Solution {
    // TC = O(n), SC = O(1)
    public int trap(int[] height) {
        int lmax = height[0];
        int rmax = height[height.length - 1];
        int l = 1;
        int r = height.length - 2;
        int res = 0;
        while(l <= r) {
            if(lmax < rmax) {
                lmax = Math.max(lmax, height[l]);
                res += (lmax - height[l]);
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                res += (rmax - height[r]);
                r--;
            }
        }
        return res;
    }
}
