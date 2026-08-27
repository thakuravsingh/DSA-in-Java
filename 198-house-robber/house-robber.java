class Solution {
    public int fxn(int[] nums, int i, int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i]+fxn(nums,i+2,dp),fxn(nums,i+1,dp));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return fxn(nums,0,dp);
    }
}