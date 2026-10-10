class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        dp[0][0][n-1] = (n != 1) ? grid[0][0] + grid[0][n-1] : grid[0][0];
        for(int i = 1; i < m; i++){
            for(int c1 = 0; c1 <= Math.min(i,n-1); c1++){
                for(int c2 = n-1; c2 >= Math.max(n-i-1,0); c2--){
                    int prevRowMax = -1;
                    for(int val1 = c1-1; val1 <= c1+1; val1++){
                        if(val1 < 0 || val1 >= n) continue;
                        for(int val2 = c2-1; val2 <= c2+1; val2++){
                            if(val2 < 0 || val2 >= n) continue;
                            prevRowMax = Math.max(prevRowMax,dp[i-1][val1][val2]);
                        }
                    }
                    dp[i][c1][c2] = prevRowMax + grid[i][c1];
                    if(c1 != c2) dp[i][c1][c2] += grid[i][c2];
                }
            }
        }
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) max = Math.max(max,dp[m-1][i][j]);
        }
        return max;
    }
}