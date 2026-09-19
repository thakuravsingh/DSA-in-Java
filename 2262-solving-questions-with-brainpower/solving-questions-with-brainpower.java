class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        Arrays.fill(dp,-1);
        return maxPoints(questions,0);
    }
    public long maxPoints(int[][] nums, int i){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        long skip = maxPoints(nums,i+1);
        int points = nums[i][0];
        int brainpower = nums[i][1];
        long pick = points + maxPoints(nums,i+brainpower+1);
        return dp[i] = Math.max(skip,pick);
    }
}