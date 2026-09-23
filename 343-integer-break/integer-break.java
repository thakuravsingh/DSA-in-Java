class Solution {
    int[][] dp;
    public int integerBreak(int n) {
        int[] nums = new int[n-1];
        for(int i = 0; i < nums.length; i++) nums[i] = i + 1;
        dp = new int[n][n+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
        return maxProduct(nums,0,n);
    }
    public int maxProduct(int[] nums, int i, int tgt){
        if(tgt == 0) return 1;
        if(i == nums.length) return 1;
        if(dp[i][tgt] != -1) return dp[i][tgt];
        int skip = maxProduct(nums,i+1,tgt);
        int pick = (tgt >= nums[i]) ? nums[i] * maxProduct(nums,i,tgt-nums[i]) : -(int)1e9;
        return dp[i][tgt] = Math.max(skip,pick);
    }
}