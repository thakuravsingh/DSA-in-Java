class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] arr = new int[m+2];
        arr[0] = 1;
        arr[m+1] = 1;
        for(int  i = 0; i < m; i++) arr[i+1] = nums[i];
        int[][] dp = new int[m][m];
        for(int gap = 0; gap < m; gap++){
            for(int i = 0; i + gap < m; i++){
                int j = gap + i;
                dp[i][j] = -(int)1e6;
                for(int k = i; k <= j; k++){
                    int left = (k == i) ? 0 : dp[i][k - 1];
                    int right = (k == j) ? 0 : dp[k + 1][j];
                    int curCost = arr[i] * arr[k+1] * arr[j+2];
                    dp[i][j] = Math.max(dp[i][j],curCost+left+right);
                }
            }
        }
        return dp[0][m-1];
    }
}