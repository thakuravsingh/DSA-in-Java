class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 2; j++) Arrays.fill(dp[i][j],-1);
        }
        return getMaxProfit(prices,0,1,0);
    }
    public int getMaxProfit(int[] prices, int i, int state, int count){
        int n = prices.length;
        if(i >= n || count >= 2) return 0;
        if(dp[i][state][count] != -1) return dp[i][state][count];
        if(state == 1){
            int buy = -prices[i] + getMaxProfit(prices,i+1,0,count);
            int skip = getMaxProfit(prices,i+1,state,count);
            return dp[i][state][count] = Math.max(buy,skip);
        }
        else{
            int sell = prices[i] + getMaxProfit(prices,i+1,1,count+1);
            int skip = getMaxProfit(prices,i+1,state,count);
            return dp[i][state][count] = Math.max(sell,skip);
        }
    }
}