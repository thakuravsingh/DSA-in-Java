class Solution {
    int mod = (int)1e9+7;
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1][3];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        return getTotalPath(grid,0,0,-1);
    }
    public int getTotalPath(int[][] grid, int i, int j, int state){
        int m = grid.length;
        int n = grid[0].length;
        if(i == m - 1 && j == n - 1) return 1;
        if(i == m || j == n) return 0;
        if(dp[i][j][state+1] != -1) return dp[i][j][state+1];
        if(state == 0 && grid[i][j] == 1) return getTotalPath(grid,i+1,j,1);
        if(state == 1 && grid[i][j] == 1) return getTotalPath(grid,i,j+1,0);
        int r = getTotalPath(grid,i,j+1,0);
        int d = getTotalPath(grid,i+1,j,1);
        return dp[i][j][state+1] = (r + d) % mod;
    }
}