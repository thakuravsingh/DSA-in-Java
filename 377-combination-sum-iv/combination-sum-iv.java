class Solution {
    int[][] dp;
    public int fxn(int[] nums, int target, int idx){
        int n = nums.length;
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target][idx] != -1) return dp[target][idx];
        int sum = 0;
        for(int i = 0; i < n; i++){
            int a = fxn(nums,target-nums[i],i);
            sum += a;
        }
        return dp[target][idx] = sum;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1][nums.length];
        for(int i = 0; i <= target; i++) Arrays.fill(dp[i],-1);
        return fxn(nums,target,0);
    }
}