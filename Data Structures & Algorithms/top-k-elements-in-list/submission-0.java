class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("map = " + freqMap);
        int[][] freqArr = new int[freqMap.size()][2];
        int l = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int[] arr = new int[2];
            arr[0] = entry.getKey();
            arr[1] = entry.getValue();
            freqArr[l++] = arr;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        for(int i = 0; i < freqArr.length; i++) {
            pq.offer(freqArr[i]);
            while(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        int m = 0;
        while(!pq.isEmpty()){
            ans[m++] = pq.peek()[0];
            pq.remove();
        }
        return ans;
    }
}
