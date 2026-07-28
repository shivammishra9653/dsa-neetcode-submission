class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            p.offer(new int[]{nums[i], i});
        }
        int l = 0;
        int r = k;
        int m = 0;
        while(r <= nums.length) {
            while(p.peek()[1] > r || p.peek()[1] < l) {
                p.poll();
            }
            res[m++] = p.peek()[0];
            if(r < nums.length){
            p.offer(new int[]{nums[r], r});
            }
            r++; l++;
        }
        return res;
    }
}
