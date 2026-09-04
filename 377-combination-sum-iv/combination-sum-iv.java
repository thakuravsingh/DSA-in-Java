class Solution {
    int[] dp;
    public int fxn(int[] nums, int target){
        int n = nums.length;
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];
        int sum = 0;
        for(int i = 0; i < n; i++){
            int a = fxn(nums,target-nums[i]);
            sum += a;
        }
        return dp[target] = sum;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        return fxn(nums,target);
    }
}