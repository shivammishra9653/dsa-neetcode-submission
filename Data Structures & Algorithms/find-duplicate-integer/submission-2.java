class Solution {

    // TC = O(n) SC = O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
           if(set.contains(nums[i])) {
            return nums[i];
           }
           set.add(nums[i]);
        }
        return -1;
    }
}
