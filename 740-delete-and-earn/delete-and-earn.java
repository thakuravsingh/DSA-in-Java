class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int ele : nums) max = Math.max(max, ele);
        int[] freq = new int[max + 1];
        for (int ele : nums) freq[ele]++;
        int[] dp = new int[max + 1];
        dp[1] = freq[1];
        if(dp.length > 2) dp[2] = Math.max(freq[1],2*freq[2]);
        for(int i = 3; i <= max; i++){
            int pick = i * freq[i] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(pick,skip);
        }
        return dp[max];
    }
}