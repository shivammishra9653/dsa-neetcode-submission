class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int product = 1;
        int ind0 = 0;
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                product *= nums[i];
            } else {
                count++;
                ind0 = i;
            }
            if(count > 1) {
                return output;
            }
        }
        if(count == 1) {
            output[ind0] = product;
        } else {
            for(int j = 0; j < output.length; j++) {
                output[j] = product/nums[j];
            }
        }
        return output;   
    }
}  
