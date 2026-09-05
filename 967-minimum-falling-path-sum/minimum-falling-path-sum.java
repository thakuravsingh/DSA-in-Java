class Solution {
    int[][] dp;
    public int getMin(int[][] matrix, int i, int j){
        int n = matrix.length;
        if(j < 0 || j == n) return Integer.MAX_VALUE;
        if(i == n - 1) return matrix[i][j];
        if(dp[i][j] !=Integer.MIN_VALUE) return dp[i][j];
        int a = getMin(matrix,i+1,j+1);
        int b = getMin(matrix,i+1,j-1);
        int c = getMin(matrix,i+1,j);
        return dp[i][j] = matrix[i][j] + Math.min(a,Math.min(b,c));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        for(int j = 0; j < n; j++) min = Math.min(min,getMin(matrix,0,j));
        return min;
    }
}