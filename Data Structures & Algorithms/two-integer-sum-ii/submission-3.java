class Solution {
    // TC = O(n^2), SC = O(1)
    public int[] twoSum(int[] numbers, int target) {
       for(int i = 0; i < numbers.length; i++) {
        int sum = numbers[i];
        for(int j = i+1; j < numbers.length; j++) {
            if(sum + numbers[j] == target) {
                return new int[]{i+1, j+1};
            }
        }
       }
       return new int[0];
    }
}
