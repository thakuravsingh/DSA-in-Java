class Solution {
    public int knightDialer(int n) {
        int mod = (int)1e9+7;
        int[][] moves = {{4, 6},{6, 8},{7, 9},{4, 8},{0, 3, 9},{},{0, 1, 7},{2, 6},{1, 3},{2, 4}};
        int[][] dp = new int[n+1][10];
        for(int j = 0; j <= 9; j++) dp[1][j] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                long sum = 0;
                for(int ele : moves[j]){
                    sum = (sum + dp[i-1][ele]) % mod;
                }
                dp[i][j] = (int)sum;
            }
        }
        int ans = 0;
        for(int j = 0; j <= 9; j++) ans = (ans + dp[n][j]) % mod;
        return ans;
    }
}