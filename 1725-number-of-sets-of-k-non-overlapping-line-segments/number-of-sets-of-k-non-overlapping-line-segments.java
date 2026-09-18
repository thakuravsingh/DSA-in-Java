class Solution {
    int[][] dp;
    int mod = (int)1e9+7;
    public int numberOfSets(int n, int k) {
        if(n == k + 1) return 1;
        dp = new int[k+1][n+1];
        for(int i = 0; i <= k; i++) Arrays.fill(dp[i],-1);
        return solve(n,k,0);
    }
    public int solve(int n, int k, int i){
        if(k == 0) return 1;
        if(i >= n) return 0;
        if(dp[k][i] != -1) return dp[k][i]; 
        int skip = solve(n,k,i+1) % mod;
        int take = 0;
        for(int j = i + 1; j <= n - 1; j++) take = (take + solve(n,k-1,j)) % mod;
        return dp[k][i] = (skip + take) % mod;
    }
}