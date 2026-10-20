class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[k+1][n+1][2];
        for(int i = 0; i <= k; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        return getMaxProfit(k,prices,0,1);
    }
    public int getMaxProfit(int k, int[] prices, int i, int state){
        int n = prices.length;
        if(i >= n || k == 0) return 0;
        if(dp[k][i][state] != -1) return dp[k][i][state];
        if(state == 1){
            int buy = -prices[i] + getMaxProfit(k,prices,i+1,0);
            int skip = getMaxProfit(k,prices,i+1,state);
            return dp[k][i][state] = Math.max(buy,skip);
        }
        else{
            int sell = prices[i] + getMaxProfit(k-1,prices,i+1,1);
            int skip = getMaxProfit(k,prices,i+1,state);
            return dp[k][i][state] = Math.max(sell,skip);
        }
    }
}