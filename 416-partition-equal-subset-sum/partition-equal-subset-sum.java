class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int tgt = sum/2;
        boolean[][] dp = new boolean[n][tgt+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        for(int j = 1; j <= tgt; j++){
            if(nums[0] == j){
                dp[0][j] = true;
                break;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= tgt; j++) {
                boolean skip = dp[i - 1][j];
                boolean pick = (j >= nums[i] && dp[i - 1][j - nums[i]]);
                dp[i][j] = skip || pick;
            }
        }
        return dp[n-1][tgt];
    }
}