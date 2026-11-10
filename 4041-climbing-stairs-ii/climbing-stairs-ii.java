class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i - 1; j >= Math.max(i-3,0); j--) min = Math.min(min,dp[j] + costs[i-1] + (i - j) * (i - j));
            dp[i] = min;
        }
        return dp[n];
    }
}