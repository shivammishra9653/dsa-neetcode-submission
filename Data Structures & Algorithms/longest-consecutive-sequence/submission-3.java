class Solution {
    // TC = O(n)
    // SC = O(n)
    public int longestConsecutive(int[] nums) {
        /**
        1. add all element in a Set so that we can search in O(1)
        2. iterate through the given array and check whether a number can be starting point of a consecutive sequence or not:
        3. if for nums[i] set contains nums[i] - 1 then nums[i] can't be the starting point of consecutive sequence
        4. If set dose not contains nums[i] - 1 then this number can be starting point of consecutive sequence so now run a loop and find the longest consecutive sequence.
        */

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int length = 0;
                while(set.contains(nums[i] + length)){
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
