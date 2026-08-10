class Solution {
    // TC = O(max * n)
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;
        int ans = 0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            int count = 0;
            for(int j = 0; j < piles.length; j++) {
                count += Math.ceil((double)piles[j]/mid);
            }
            if(count <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
