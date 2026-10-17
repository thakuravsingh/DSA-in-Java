class Solution {
    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],(int)1e9);
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                int ans = 0;
                for(int k = nums[i-1]; k <= j; k*=2){
                    int skip = dp[i-1][j];
                    int pick = ans + dp[i-1][j-k];
                    dp[i][j] = Math.min(dp[i][j],Math.min(skip,pick));
                    ans++;
                }
                ans = 0;
                for(int k = nums[i-1]; k >= 1; k/=2){
                    if(k <= j){
                        int skip = dp[i-1][j];
                        int pick = ans + dp[i-1][j-k];
                        dp[i][j] = Math.min(dp[i][j],Math.min(skip,pick));
                    }
                    ans++;
                }
            }
        }
        return dp[n][sum] <= 5000 ? dp[n][sum] : -1;
    }
}