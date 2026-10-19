class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        return getMax(prices,0,1);
    }
    public int getMax(int[] prices, int i, int state){
        int n = prices.length;
        if(i >= n) return 0;
        if(dp[i][state] != -1) return dp[i][state];
        if(state == 1){
            int buy = -prices[i] + getMax(prices,i+1,0);
            int skip = getMax(prices,i+1,1);
            return dp[i][state] = Math.max(buy,skip);
        }
        else{
            int sell = prices[i] + getMax(prices,i+1,1);
            int skip = getMax(prices,i+1,0);
            return dp[i][state] = Math.max(sell,skip);
        }
    }
}