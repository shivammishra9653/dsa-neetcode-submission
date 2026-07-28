class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] == num + 1) {
                    count++;
                    num = nums[j];
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
