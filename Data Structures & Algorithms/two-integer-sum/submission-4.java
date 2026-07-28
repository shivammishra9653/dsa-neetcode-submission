class Solution {
    public int[] twoSum(int[] nums, int target) {        
        Map<Integer, Integer> compMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(compMap.containsKey(complement)) {
                return new int[]{compMap.get(complement), i};
            }
            compMap.put(nums[i], i);
        }
        return new int[0];
    }
}
