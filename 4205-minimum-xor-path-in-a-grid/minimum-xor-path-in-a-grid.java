class Solution {
    int ans = Integer.MAX_VALUE;
    boolean[][][] dp;
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new boolean[m+1][n+1][1<<10];
        getMinCost(grid,0,0,0);
        return ans;
    }
    public void getMinCost(int[][] grid, int i, int j, int xor){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n) return;
        int curXor = xor ^ grid[i][j];
        if(i == m - 1 && j == n - 1){
            ans = Math.min(ans,curXor);
            return;
        }
        if(dp[i][j][xor]) return;
        dp[i][j][xor] = true;
        getMinCost(grid,i,j+1,xor^grid[i][j]);
        getMinCost(grid,i+1,j,xor^grid[i][j]);
    }
}