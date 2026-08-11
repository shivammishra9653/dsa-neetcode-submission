class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }

        while(i < nums1.length) {
            merge[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            merge[k++] = nums2[j++];
        }

        double res = 0;
        if(merge.length%2 == 0) {
            int mid1 = merge.length/2;
            int mid2 = mid1-1;
            res = (double)(merge[mid1] + merge[mid2])/2;
        } else {
            int mid = merge.length/2;
            res = merge[mid];
        }
        return res;
        
    }
}
