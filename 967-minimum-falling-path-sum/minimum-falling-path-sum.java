class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int a = (j != 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int b = dp[i-1][j];
                int c = (j != n - 1) ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(a,Math.min(b,c));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) min = Math.min(min,dp[n-1][j]);
        return min;
    }
}