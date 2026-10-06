class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        return lis(nums,0,-1);
    }
    public int lis(int[] nums, int i, int prev){
        int n = nums.length;
        if(i == n) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int skip = lis(nums,i+1,prev);
        int pick = (prev == -1 || nums[prev] < nums[i]) ? 1 + lis(nums,i+1,i) : -1;
        return dp[i][prev+1] = Math.max(skip,pick);
    }
}