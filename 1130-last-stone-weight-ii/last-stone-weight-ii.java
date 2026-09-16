class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int ele : stones) sum += ele;
        dp = new int[n][sum+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
        return minDiff(stones,sum,0,0);
    }
    public int minDiff(int[] nums, int sum, int i, int cur){
        int n = nums.length;
        if(i == n) return Math.abs(sum-2*cur);
        if(dp[i][cur] != -1) return dp[i][cur];
        return dp[i][cur] = Math.min(minDiff(nums,sum,i+1,cur),minDiff(nums,sum,i+1,cur+nums[i]));
    }
}