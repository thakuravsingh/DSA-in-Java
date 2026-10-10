class Solution {
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        int ans = 0;
        for(int i = 0; i < m; i++) ans = Math.max(ans,getMax(grid,i,0));
        return ans;
    }
    public int getMax(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        // if(j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        int newC = j + 1;
        for(int row = -1; row <= 1; row++){
            int newR = i + row;
            if(newR < 0 || newR >= m || newC >= n) continue;
            if(grid[newR][newC] <= grid[i][j]) continue;
            ans = Math.max(ans,1+getMax(grid,newR,newC));
        }
        return dp[i][j] = ans;
    }
}