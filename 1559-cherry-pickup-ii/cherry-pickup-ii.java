class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        return maxCherry(grid,0,0,n-1);
    }
    public int maxCherry(int[][] grid, int row, int col1, int col2){
        int m = grid.length;
        int n = grid[0].length;
        if(row == m - 1) return (col1 != col2) ? grid[row][col1] + grid[row][col2] : grid[row][col1];
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];
        int ans = -1;
        int pick = (col1 != col2) ? grid[row][col1] + grid[row][col2] : grid[row][col1];
        for(int val1 = -1; val1 <= 1; val1++){
            int newC1 = col1 + val1;
            if(newC1 < 0 || newC1 >= n) continue;
            for(int val2 = -1; val2 <= 1; val2++){
                int newC2 = col2 + val2;
                if(newC2 < 0 || newC2 >= n) continue;
                ans = Math.max(ans,maxCherry(grid,row+1,newC1,newC2));
            }
        }
        return dp[row][col1][col2] = ans + pick;
    }
}