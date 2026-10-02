class Solution {
    int[][] dp;
    int mod = (int)1e9+7;
    public int knightDialer(int n) {
        int[][] moves = {{4, 6},{6, 8},{7, 9},{4, 8},{0, 3, 9},{},{0, 1, 7},{2, 6},{1, 3},{2, 4}};
        dp = new int[n+1][10];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        long ans = 0;
        for(int i = 0; i <= 9; i++){
            ans = (ans + fxn(moves,n-1,i)) % mod;
        }
        return (int)ans;
    }
    public int fxn(int[][] moves, int n, int curPos){
        if(n == 0) return 1;
        if(dp[n][curPos] != -1) return dp[n][curPos];
        long sum = 0;
        for(int ele : moves[curPos]){
            sum = (sum + fxn(moves,n-1,ele)) % mod;
        }
        return dp[n][curPos] = (int)sum;
    }
}