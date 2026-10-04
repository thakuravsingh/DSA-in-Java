class Solution {
    int mod = (int)1e9+7;
    Pair[][] dp;
    class Pair{
        long maxVal;
        long minVal;
        Pair(long maxVal, long minVal){
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Pair[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],new Pair(Long.MIN_VALUE,Long.MAX_VALUE));
        Pair ans = maxProduct(grid,0,0);
        return ans.maxVal >= 0 ? (int)(ans.maxVal%mod) : -1;
    }
    public Pair maxProduct(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i == m - 1 && j == n - 1) return new Pair(grid[i][j],grid[i][j]);
        if(dp[i][j].maxVal != Long.MIN_VALUE && dp[i][j].minVal != Long.MAX_VALUE) return dp[i][j];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        if(j + 1 < n){
            Pair r = maxProduct(grid,i,j+1);
            max = Math.max(max,Math.max(grid[i][j]*r.maxVal,grid[i][j]*r.minVal));
            min = Math.min(min,Math.min(grid[i][j]*r.maxVal,grid[i][j]*r.minVal));
        }
        if(i + 1 < m){
            Pair d = maxProduct(grid,i+1,j);
            max = Math.max(max,Math.max(grid[i][j]*d.maxVal,grid[i][j]*d.minVal));
            min = Math.min(min,Math.min(grid[i][j]*d.maxVal,grid[i][j]*d.minVal));
        }
        return dp[i][j] = new Pair(max,min);
    }
}