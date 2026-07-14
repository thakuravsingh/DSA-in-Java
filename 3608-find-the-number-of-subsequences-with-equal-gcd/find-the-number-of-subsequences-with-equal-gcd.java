class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int helper(int[] nums, int i, int first, int sec, int[][][] dp){
        if(i == nums.length){
            if(first != 0 && sec != 0){
                if(first == sec) return 1;
            }
            return 0;
        }
        if(dp[i][first][sec] != -1) return dp[i][first][sec];
        int skip = helper(nums,i+1,first,sec,dp);
        int take1 = helper(nums,i+1,gcd(first,nums[i]),sec,dp);
        int take2 = helper(nums,i+1,first,gcd(sec,nums[i]),dp);
        return dp[i][first][sec] = ((skip + take1) % 1000000007 + take2) % 1000000007;
    }
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n+1][201][201];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 201; j++) Arrays.fill(dp[i][j],-1);
        }
        return helper(nums,0,0,0,dp);
    }
}