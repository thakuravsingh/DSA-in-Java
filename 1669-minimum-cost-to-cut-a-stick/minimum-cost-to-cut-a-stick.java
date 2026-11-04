class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int[] nums = new int[cuts.length+2];
        nums[0] = 0;
        nums[cuts.length+1] = n;
        for(int i = 0; i < cuts.length; i++) nums[i+1] = cuts[i];
        int m = nums.length;
        Arrays.sort(nums);
        dp = new int[m+1][m+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        return getMinCost(nums,1,m-1);
    }
    public int getMinCost(int[] nums, int i, int j){
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for(int k = i; k < j; k++){
            int curCost = nums[j] - nums[i-1];
            min = Math.min(min,curCost+getMinCost(nums,i,k)+getMinCost(nums,k+1,j));
        }
        return dp[i][j] = min;
    }
}