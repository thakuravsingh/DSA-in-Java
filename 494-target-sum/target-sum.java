class Solution {
    public int findTargetSumWays(int[] nums, int tgt) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 2000; j++) {
                int plus = (j - nums[i] >= 0) ? dp[i-1][j-nums[i]] : 0;
                int minus = (j + nums[i] <= 2000) ? dp[i-1][j + nums[i]] : 0;
                dp[i][j] = plus + minus;
            }
        }
        return dp[n-1][tgt+1000];
    }
}