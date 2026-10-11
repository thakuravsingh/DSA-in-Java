class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],(int)1e5);
        int ans = (int)1e5;
        for(int j = 0; j < n; j++) ans = Math.min(ans,getMinFallingPathSum(grid,0,j));
        return ans;
    }
    public int getMinFallingPathSum(int[][] grid, int i, int j){
        int n = grid.length;
        if(i == n-1) return grid[i][j];
        if(dp[i][j] != (int)1e5) return dp[i][j];
        int ans = (int)1e5;
        for(int idx = 0; idx < n; idx++){
            if(idx != j) ans = Math.min(ans,grid[i][j]+getMinFallingPathSum(grid,i+1,idx));
        }
        return dp[i][j] = ans;
    }
}