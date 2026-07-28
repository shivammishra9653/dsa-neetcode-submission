class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // if list is having the same numbers in same order then set will
        //  consider it duplicates if we try to add more than 1 times
        Set<List<Integer>> set = new HashSet<>();

        // sorting help us to keep triplet numbers in order to avoid the duplicates in Set
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
