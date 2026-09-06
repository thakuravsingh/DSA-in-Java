class Solution {
    int[][] dp;
    public int fxn(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int first = fxn(triangle,i+1,j);
        int sec = fxn(triangle,i+1,j+1);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(first,sec);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return fxn(triangle,0,0);
    }
}