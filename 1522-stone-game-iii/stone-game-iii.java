class Solution {
    public int helper(int[] nums, int i, int[] dp){
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int result = Integer.MIN_VALUE;
        result = Math.max(result,nums[i]-helper(nums,i+1,dp));
        if(i < n - 1) result = Math.max(result,nums[i]+nums[i+1]-helper(nums,i+2,dp));
        if(i < n - 2) result = Math.max(result,nums[i]+nums[i+1]+nums[i+2]-helper(nums,i+3,dp));
        return dp[i] = result;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int result = helper(stoneValue,0,dp);
        if(result > 0) return "Alice";
        else if(result < 0) return "Bob";
        else return "Tie";
    }
}