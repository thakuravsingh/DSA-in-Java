class Solution {
    public int helper(int n, int player, int[][] dp){
        if(n == 0) {
            if(player == 0) return 1;
            else return 0;
        }
        if(dp[n][player] != -1) return dp[n][player];
        boolean ans = false;
        int start = 1;
        for(int i = 1; i <= n; i = (start * start)){
            if(player == 1){
                ans = (helper(n-i,0,dp) == 1) ? true : false;
                if(ans) break;
            } else{
                ans = (helper(n-i,1,dp) == 1) ? true : false;
                if(!ans) break;
            }
            start++;
        }
        return dp[n][player] = (ans) ? 1 : 0;
    }
    public boolean winnerSquareGame(int n) {
        int[][] dp = new int[n+1][2];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        int ans = helper(n,1,dp);
        return ans == 1;
    }
}