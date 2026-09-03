class Solution {
    int[][] dp;
    public int fxn(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i == m - 1 && j == n - 1) return 1;
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = i < m - 1 ? ((grid[i+1][j] == 0) ? fxn(i+1,j,grid) : 0) : fxn(i+1,j,grid);
        int right = j < n - 1 ? ((grid[i][j+1] == 0) ? fxn(i,j+1,grid) : 0) : fxn(i,j+1,grid);
        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m-1][n-1] == 1 || grid[0][0] == 1) return 0;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i],-1);
        return fxn(0,0,grid);
    }
}