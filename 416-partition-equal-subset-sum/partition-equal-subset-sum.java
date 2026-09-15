class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        dp = new Boolean[n+1][sum/2+1];
        return isPossible(nums,0,sum/2);
    }
    public boolean isPossible(int[] nums, int i, int tgt){
        if(i == nums.length) return false;
        if(tgt == 0) return true;
        if(dp[i][tgt] != null) return dp[i][tgt];
        boolean skip = isPossible(nums,i+1,tgt);
        boolean pick = false;
        if(tgt >= nums[i]) pick = isPossible(nums,i+1,tgt-nums[i]);
        boolean ans = skip || pick;
        return dp[i][tgt] = ans;
    }
}