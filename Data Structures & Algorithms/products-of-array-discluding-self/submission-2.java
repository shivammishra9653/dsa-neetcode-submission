class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int count = 0;
        int product = 1;
        int ind0 = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
                ind0  = i;
            } else {
                product *= nums[i];
            }
            if(count > 1) {
                return output;
            }
        }
        if(ind0 != -1) {
            output[ind0] = product;
            return output;
        } else {
            for(int i = 0; i < nums.length; i++) {
                output[i] = product/nums[i];
            }
        }
        return output;
        
    }
}  
