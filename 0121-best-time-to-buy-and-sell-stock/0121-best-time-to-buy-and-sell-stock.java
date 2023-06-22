class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0]; 
        int diff=0;
        for(int i = 1; i < prices.length; i++) {
            min = min > prices[i] ? prices[i] : min;
            diff = prices[i] - min > diff ? prices[i] - min : diff;
        }
        return diff;
    }
}