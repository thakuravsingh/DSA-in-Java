class Solution {
    int[][] dp;
    public int fxn(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n) return (int)1e9;
        if(i == m - 1 && j == n - 1) return grid[i][j] >= 0 ? 1 : Math.abs(grid[i][j]) + 1;
        if(dp[i][j] != -1) return dp[i][j];
        int r = fxn(grid,i+1,j);
        int d = fxn(grid,i,j+1);
        int res = grid[i][j] - Math.min(r,d);
        return dp[i][j] = res >= 0 ? 1 : Math.abs(res);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        dp = new int[201][201];
        for(int i = 0; i < 201; i++) Arrays.fill(dp[i],-1);
        return fxn(dungeon,0,0);
    }
}