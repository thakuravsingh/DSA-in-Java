class Solution {
    long[][] dp;
    public long maxDifference(int[] nums) {
        int n = nums.length;
        dp = new long[n+1][2];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],Long.MAX_VALUE);
        return fxn(nums,0,0);
    }
    public long fxn(int[] nums, int i, int state){
        int n = nums.length;
        if(i >= n) return 0;
        if(dp[i][state] != Long.MAX_VALUE) return dp[i][state];
        if(state == 0){
            long one = nums[i];
            long pickOne = one % 3 != 0 ? one + fxn(nums,i+1,0) : one + fxn(nums,i+1,1);
            if(i >= n -1) return dp[i][state] = pickOne;
            long two = nums[i] + nums[i+1];
            long pickTwo = two % 3 != 0 ? two + fxn(nums,i+2,0) : two + fxn(nums,i+2,1);
            return dp[i][state] = Math.max(pickOne,pickTwo);
        }
        else{
            long one = nums[i];
            long pickOne = one % 3 != 0 ? -one + fxn(nums,i+1,1) : -one + fxn(nums,i+1,0);
            if(i >= n -1) return dp[i][state] = pickOne;
            long two = nums[i] + nums[i+1];
            long pickTwo = two % 3 != 0 ? -two + fxn(nums,i+2,1) : -two + fxn(nums,i+2,0);
            return dp[i][state] = Math.min(pickOne,pickTwo);
        }
    }
}