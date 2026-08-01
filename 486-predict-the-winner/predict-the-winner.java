class Solution {
    public int helper(int[] nums, int i, int j, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int begin = nums[i] + Math.min(helper(nums,i+2,j,dp),helper(nums,i+1,j-1,dp));
        int end = nums[j] + Math.min(helper(nums,i,j-2,dp),helper(nums,i+1,j-1,dp));
        return dp[i][j] = Math.max(begin,end);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
        int sum = 0;
        for(int ele : nums) sum += ele;
        int player1 = helper(nums,0,n-1,dp);
        int player2 = sum - player1;
        return (player1 >= player2);
    }
}