class Solution {
    int [][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[n][2001];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
        return findWays(nums,target,0,0);
    }
    public int findWays(int[] nums, int tgt, int i, int cur){
        int n = nums.length;
        if(i == n){
            if(cur == tgt) return 1;
            else return 0;
        }
        if(dp[i][cur+1000]!=-1) return dp[i][cur+1000];
        int minus = findWays(nums,tgt,i+1,cur-nums[i]);
        int add = findWays(nums,tgt,i+1,cur+nums[i]);
        return dp[i][cur+1000] = minus+add;
    }
}