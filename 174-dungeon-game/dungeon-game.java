class Solution {
    int[][] dp;
    public int minHealth(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n) return (int)1e9;
        if(i == m-1 && j == n - 1) return grid[i][j] <= 0 ? -grid[i][j] + 1 : 1;
        if(dp[i][j] != -1) return dp[i][j];
        int r = minHealth(grid,i,j+1);
        int d = minHealth(grid,i+1,j);
        int res = grid[i][j] - Math.min(r,d);
        return dp[i][j] = res < 0 ? -res : 1;
    }
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i],-1);
        return minHealth(grid,0,0);
    }
}