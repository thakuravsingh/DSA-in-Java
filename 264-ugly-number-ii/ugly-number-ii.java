class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int i = 1;
        int j = 1;
        int k = 1;
        for(int idx = 2; idx <= n; idx++){
            int a = dp[i] * 2;
            int b = dp[j] * 3;
            int c = dp[k] * 5;
            dp[idx] = Math.min(a,Math.min(b,c));
            if(a == dp[idx]) i++;
            if(b == dp[idx]) j++;
            if(c == dp[idx]) k++;
        }
        return dp[n];
    }
}