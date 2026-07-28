class Solution {

    // TC = O(n^3), SC = O(m) m is the number of unique triplets
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

    // for making the sum 0 there must be at least one negative number
    // since array is sorted so if first element is +ve number then 
    // subsequent numbers must be +ve that's why we are breaking the loop from here
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1; 
            int r = nums.length - 1;
            while(l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if(sum > 0) {
                r--;
            } else if(sum < 0) {
                l++;
            } else {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
// since we don't want duplicate triplets number so if after increasing the value
//  of l and decreasing the value of r if number nums[l] == nums[l-1] and nums[r] == nums[r+1] and nums[i] == nums[i-1]
//  then it will again create duplicate triplets e.g [-2, -2, 0, 0, 2, 2]
// to avoid such scenario we need move either l or r untill it reaches to the value where nums[l] != nums[l-1]
               while(l < r && nums[l] == nums[l-1]) {
                l++;
               }
            }
         }
        }
        return res;
    }
}
