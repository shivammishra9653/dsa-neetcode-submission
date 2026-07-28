class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k;
        int i = 0;
        int[] res = new int[nums.length - k + 1];
// TC = O(nk) -> if k = n/2 then TC = O(n^2)
        while(r <= nums.length) {
            int max = Integer.MIN_VALUE;
            for(int j = l; j < r; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i++] = max;
            l++; r++;
        }
        return res;
        
    }
}
