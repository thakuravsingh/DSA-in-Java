class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] nums = new int[m+2];
        nums[0] = 0;
        nums[m+1] = n;
        for(int i = 1; i <= m; i++) nums[i] = cuts[i-1];
        Arrays.sort(nums);
        int len = nums.length;
        dp = new int[len+1][len+1];
        for(int i = 0; i <= len; i++) Arrays.fill(dp[i],-1);
        return getMinCost(nums,1,m);
    }
    public int getMinCost(int[] nums, int i, int j){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = (int)1e9;
        for(int k = i; k <= j; k++){
            int curCost = getMinCost(nums,i,k-1) + getMinCost(nums,k+1,j) + nums[j+1] - nums[i-1];
            ans = Math.min(ans,curCost);
        }
        return dp[i][j] = ans;
    }
}