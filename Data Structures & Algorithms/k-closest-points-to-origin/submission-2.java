class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < points.length; i++) {
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new int[]{dist, i});
        }
        int[][] ans = new int[k][2];
        for(int j = 0; j < k; j++) {
            ans[j] = points[pq.peek()[1]];
            pq.poll();
        }
        return ans;
    }
}
