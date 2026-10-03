class Solution {
    int[][][] dp;
    public int minSteps(int n) {
        dp = new int[n+1][n+1][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        return minOp(n,0,1,-1);
    }
    public int minOp(int n, int copy,int tot, int state){
        if(n == tot) return 0;
        if(n < tot) return (int)1e9+7;
        if(dp[copy][tot][state+1] != -1) return dp[copy][tot][state+1];
        int a = state != 0 ? 1 + minOp(n,tot,tot,0) : (int)1e9+7;
        int b = state != -1 ? 1 + minOp(n,copy,tot+copy,1) : (int)1e9+7;
        return dp[copy][tot][state+1] = Math.min(a,b);
    }
}