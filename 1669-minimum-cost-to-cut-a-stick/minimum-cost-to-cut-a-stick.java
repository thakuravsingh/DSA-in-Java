class Solution {
    public int minCost(int n, int[] cuts) {
        int[] nums = new int[cuts.length+2];
        nums[0] = 0;
        nums[cuts.length+1] = n;
        for(int i = 0; i < cuts.length; i++) nums[i+1] = cuts[i];
        int m = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[m-1][m-1];
        for(int gap = 1; gap < dp.length; gap++){
            for(int i = 0; i + gap < dp.length; i++){
                int j = gap + i;
                dp[i][j] = (int)1e9;
                for(int k = i; k < j; k++){
                    int curCost = nums[j+1] - nums[i];
                    dp[i][j] = Math.min(dp[i][j],curCost+dp[i][k]+dp[k+1][j]);
                }
            }
        }
        return dp[0][dp.length-1];
    }
}