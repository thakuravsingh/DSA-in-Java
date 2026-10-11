class Solution {
    int[][] dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        int ans = (int)1e9;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans,getMinCost(grid,moveCost,0,j));
        }
        return ans;
    }
    public int getMinCost(int[][] grid, int[][] move, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i == m-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int ans = (int)1e9;
        for(int idx = 0; idx < n; idx++){
            ans = Math.min(ans,grid[i][j]+move[grid[i][j]][idx]+getMinCost(grid,move,i+1,idx));
        }
        return dp[i][j] = ans;
    }
}