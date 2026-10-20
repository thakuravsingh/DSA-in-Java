class Solution {
    long[] dp;
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return maxProfit(nums,colors,0);
    }
    public long maxProfit(int[] nums, int[] colors, int i){
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        long skip = maxProfit(nums,colors,i+1);
        long pick = (i == n - 1 || colors[i+1] == colors[i]) ? nums[i] + maxProfit(nums,colors,i+2) : nums[i] + maxProfit(nums,colors,i+1);
        return dp[i] = Math.max(pick,skip);
    }
}