class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.getFirst().size();
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = grid.get(i).get(j);
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = -(int)1e9;
        for(int j = 1; j < n; j++){
            int left = mat[0][j] - mat[0][j-1];
            dp[0][j] = Math.max(left,dp[0][j-1]+left);
        }
        for(int i = 1; i < m; i++){
            int up = mat[i][0] - mat[i-1][0];
            dp[i][0] = Math.max(up,dp[i-1][0]+up);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int left = Math.max(mat[i][j]-mat[i][j-1],dp[i][j-1]+mat[i][j]-mat[i][j-1]);
                int up = Math.max(mat[i][j]-mat[i-1][j],dp[i-1][j]+mat[i][j]-mat[i-1][j]);
                dp[i][j] = Math.max(left,up);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] ele : dp){
            for(int val : ele) max = Math.max(max,val);
        }
        return max;
    }
}