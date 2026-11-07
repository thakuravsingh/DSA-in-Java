class Solution {
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n+1][2];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        return getMaxSum(nums,0,0);
    }
    public long getMaxSum(int[] nums, int i, int index){
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i][index] != -1) return dp[i][index];
        long skip = getMaxSum(nums,i+1,index);
        long pick = (index == 0) ? nums[i] + getMaxSum(nums,i+1,1) : -nums[i] + getMaxSum(nums,i+1,0);
        return dp[i][index] = Math.max(pick,skip);
    }
}