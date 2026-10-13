class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
       
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int j = 0; j < count.length; j++) {
            if(count[j] > 0) {
                pq.offer(count[j]);
            }
        }

        int ans = 0;
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int k = 0; k <= n; k++) {
                if(pq.isEmpty()){
                    break;
                }
                int freq = pq.poll() - 1;
                temp.add(freq);
            }
             for(int num : temp) {
                if(num > 0) {
                    pq.offer(num);
                }
            }
            ans += pq.isEmpty() ? temp.size() : n+1;
           
        }
        return ans;
    }
}
