class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        dp = new Boolean[m+1][n+1][m+n+1];
        return isValid(grid,0,0,0);
    }
    public boolean isValid(char[][] grid, int i, int j, int count){
        int m = grid.length;
        int n = grid[0].length;
        if(count > m + n) return false;
        if(i >= m || j >= n) return false;
        if(i == m - 1 && j == n - 1) return count == 1;
        if(count < 0) return false;
        if(dp[i][j][count] != null) return dp[i][j][count];
        boolean right = (grid[i][j] == '(') ? isValid(grid,i,j+1,count+1) : isValid(grid,i,j+1,count-1);
        boolean down = (grid[i][j] == '(') ? isValid(grid,i+1,j,count+1) : isValid(grid,i+1,j,count-1);
        return dp[i][j][count] = right || down;
    }
}