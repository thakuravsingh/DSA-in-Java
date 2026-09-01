class Solution {
    int[] dp;
    public int fxn(int[] freq, int idx) {
        if (idx >= freq.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int pick = idx * freq[idx];
        return dp[idx] = Math.max(fxn(freq, idx + 1), pick + fxn(freq, idx + 2));
    }
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int ele : nums) max = Math.max(max, ele);
        int[] freq = new int[max + 1];
        for (int ele : nums) freq[ele]++;
        dp = new int[max + 1];
        Arrays.fill(dp, -1);
        return fxn(freq, 1);
    }
}