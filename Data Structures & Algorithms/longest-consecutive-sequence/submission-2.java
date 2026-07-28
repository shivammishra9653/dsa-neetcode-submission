class Solution {
    // TC = O(nlogn)
    // SC = O(1)
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int count = 1;
        int num = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == num) {
                continue;
            }

            if(nums[i] == num + 1) {
                count++;
                num = nums[i];
            } else {
                ans = Math.max(ans, count);
                count = 1;
                num = nums[i];
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}
