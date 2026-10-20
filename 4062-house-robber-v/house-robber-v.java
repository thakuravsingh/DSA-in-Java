class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--) {
            long skip = dp[i+1];
            long pick = (colors[i+1] == colors[i]) ? nums[i] + (i+2 < n ? dp[i+2] : 0) : nums[i] + dp[i+1];
            dp[i] = Math.max(skip,pick);
        }
        return dp[0];
    }
}