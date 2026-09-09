class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1] < 0 ? -grid[m-1][n-1] + 1 : 1;
        for(int j = n - 2; j >= 0; j--){
            int r = grid[m-1][j] - dp[m-1][j+1];
            dp[m-1][j] = r < 0 ? -r : 1;
        }
        for(int i = m - 2; i >= 0; i--){
            int d = grid[i][n-1] - dp[i+1][n-1];
            dp[i][n-1] = d < 0 ? -d : 1;
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int res = grid[i][j] - Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = res < 0 ? -res : 1;
            }
        }
        return dp[0][0];
    }
}