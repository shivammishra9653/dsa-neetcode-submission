class Solution {

    // TC = O(n^2) SC = O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

//  buying the stock on ith day
        for(int i = 0; i < prices.length - 1; i++) {

            // selling the stock on jth day
            for(int j = i+1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }
}
