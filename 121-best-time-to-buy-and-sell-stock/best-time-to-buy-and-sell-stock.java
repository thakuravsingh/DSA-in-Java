class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffixMax = new int[n];
        suffixMax[n-1] = prices[n-1];
        for(int i = n - 2; i >= 0; i--) suffixMax[i] = Math.max(prices[i],suffixMax[i+1]);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++) ans = Math.max(ans,suffixMax[i+1]-prices[i]);
        return (ans >= 0) ? ans : 0;
    }
}