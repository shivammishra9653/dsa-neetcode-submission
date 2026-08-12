class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int leftSize = (n1+n2+1)/2;
        double res = 0;
        int l = 0;
        int r = n1;
       while(l <= r) {
            int mid = l + (r-l)/2;

            int p2 = leftSize - mid;

            int l1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            int r1 = (mid == n1) ? Integer.MAX_VALUE : nums1[mid];

            int l2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
            int r2 = (p2 == n2) ? Integer.MAX_VALUE : nums2[p2];
            if(l1 <= r2 && l2 <= r1) {
                if((n1+n2)%2 == 0) {
                    res = (double)(Math.max(l1, l2) + Math.min(r1, r2))/2;
                    return res;
                }
                return Math.max(l1, l2);
            }
            if(l1 > r2) {
                r = mid-1;
            } else if(l2 > r1) {
                l = mid+1;
            }
        }
        return res;
    }
}
