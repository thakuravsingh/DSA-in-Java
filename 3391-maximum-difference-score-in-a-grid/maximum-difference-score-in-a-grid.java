class Solution {
    int[][] dp;
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.getFirst().size();
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max,getMax(grid,i,j));
            }
        }
        return max;
    }
    public int getMax(List<List<Integer>> grid, int i, int j){
        int m = grid.size();
        int n = grid.getFirst().size();
        if(i == m || j == n) return -(int)1e9;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int r = (j + 1 < n) ? grid.get(i).get(j+1) - grid.get(i).get(j) : -(int)1e9;
        int d = (i + 1 < m) ? grid.get(i+1).get(j) - grid.get(i).get(j) : -(int)1e9;
        int right = getMax(grid,i,j+1);
        int down = getMax(grid,i+1,j);
        if(right > 0) r += right;
        if(down > 0) d += down;
        return dp[i][j] = Math.max(r,d);
    }
}