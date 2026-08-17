class Solution {

    // TC = O(n^2) SC = O(1)
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] == nums[i]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
