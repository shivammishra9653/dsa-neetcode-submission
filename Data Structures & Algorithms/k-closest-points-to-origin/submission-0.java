class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int i = 0; i < points.length; i++) {
            double dist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
             pq.offer(new double[]{dist, i});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int j = 0;
        
        while(!pq.isEmpty()) {
            int i = (int)pq.peek()[1];
            pq.poll();
            ans[j++] = points[i];
        }
        return ans;
    }
}
