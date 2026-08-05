class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for(int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> a[0] - b[0]);

        int count = 1;
        double minTime = (double)(target-pair[n-1][0])/pair[n-1][1];
        for(int i = n-2; i >= 0; i--) {
            double time = (double)(target-pair[i][0])/pair[i][1];
            if(time > minTime){
                count++;
                minTime = time;
            }
        }
        return count;
    }
}
