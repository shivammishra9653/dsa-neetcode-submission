class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> dq = new ArrayDeque<>();
       int[] res = new int[nums.length - k + 1];
       for(int i = 0; i < k; i++) {
        while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
            dq.pollLast();
        }
        dq.offerLast(i);
       }
       int m = 0;
       res[m++] = nums[dq.peekFirst()];
       int r = k;
       while(r < nums.length) {
        while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]){
            dq.pollLast();
        }
        while(!dq.isEmpty() && dq.peekFirst() < (r-k+1)){
            dq.pollFirst();
        }
        dq.offerLast(r);
        res[m++] = nums[dq.peekFirst()];
        r++;
       }
       return res;
    }
}
