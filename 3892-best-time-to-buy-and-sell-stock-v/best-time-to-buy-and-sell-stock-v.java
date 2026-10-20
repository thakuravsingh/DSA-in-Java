class Solution {
    long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[k+1][n+1][3];
        for(int i = 0; i <= k; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        return getMaxProfit(prices,k,0,2);
    }
    public long getMaxProfit(int[] prices, int k, int i, int state){
        int n = prices.length;
        if (i == n) return state == 2 ? 0 : Long.MIN_VALUE / 2;
        if (k == 0) return 0;
        if(dp[k][i][state] != -1) return dp[k][i][state];
        if(state == 2){
            long buy = -prices[i] + getMaxProfit(prices,k,i+1,0);
            long sell = prices[i] + getMaxProfit(prices,k,i+1,1);
            long skip = getMaxProfit(prices,k,i+1,2);
            return dp[k][i][state] = Math.max(skip,Math.max(buy,sell));
        }
        else if(state == 1){
            long buy = -prices[i] + getMaxProfit(prices,k-1,i+1,2);
            long skip = getMaxProfit(prices,k,i+1,state);
            return dp[k][i][state] = Math.max(buy,skip);
        }
        else{
            long sell = prices[i] + getMaxProfit(prices,k-1,i+1,2);
            long skip = getMaxProfit(prices,k,i+1,state);
            return dp[k][i][state] = Math.max(sell,skip);
        }
    }
}