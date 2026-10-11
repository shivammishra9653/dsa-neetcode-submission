class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < points.length; i++) {
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new int[]{dist, i});
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int j = 0;
        while(!pq.isEmpty()) {
            ans[j++] = points[pq.peek()[1]];
            pq.poll();
        }
        return ans;
    }
}
