class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int[][][] dp;
    int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        dp = new int[maxMove+1][m+1][n+1];
        for(int i = 0; i <= maxMove; i++){
            for(int j = 0; j <= m; j++) Arrays.fill(dp[i][j],-1);
        }
        return getAns(m,n,maxMove,startRow,startCol);
    }
    public int getAns(int m, int n, int maxMove, int i, int j){
        if(maxMove == 0) return 0;
        if(dp[maxMove][i][j] != -1) return dp[maxMove][i][j];
        int ans = 0;
        for(int idx = 0; idx < 4; idx++){
            int newR = i + dir[idx][0];
            int newC = j + dir[idx][1];
            if(newR < 0 || newR >= m || newC < 0 || newC >= n) ans = (ans+1)%mod;
            else ans = (ans + getAns(m,n,maxMove-1,newR,newC)) % mod;
        }
        return dp[maxMove][i][j] = ans;
    }
}