class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        if(nums.length == 0) {
            return;
        }
        int i = 0;
        while(i < k && i < nums.length) {
            pq.offer(nums[i++]);
        }
        while(i < nums.length) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
            i++;
        }
        
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < k) {
            pq.offer(val);
            return pq.peek();
        }
        if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        
        return pq.peek();
    }
}
