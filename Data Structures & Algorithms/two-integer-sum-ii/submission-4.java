class Solution {
    // TC = O(nlogn), SC = O(1)
    public int[] twoSum(int[] numbers, int target) {
       for(int i = 0; i < numbers.length; i++) {
        int comp = target - numbers[i];
        int l = i+1;
        int r = numbers.length - 1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(numbers[mid] == comp) {
                return new int[]{i+1, mid+1};
            }

            if(numbers[mid] > comp) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        
       }
       return new int[0];
    }
}
