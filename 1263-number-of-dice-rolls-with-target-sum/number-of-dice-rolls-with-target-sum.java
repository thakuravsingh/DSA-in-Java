class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[31][1001];
        for(int i = 0; i <= 30; i++) Arrays.fill(dp[i],-1);
        return getReqAns(n,k,target);
    }
    public int getReqAns(int n, int k, int tgt){
        if(n == 0){
            if(tgt == 0) return 1;
            else return 0;
        }
        if(tgt < 0) return 0;
        if(dp[n][tgt] != -1) return dp[n][tgt];
        int ans = 0;
        for(int i = 1; i <= k; i++){
            ans = (ans + getReqAns(n-1,k,tgt-i)) % mod;
        }
        return dp[n][tgt] = ans;
    }
}