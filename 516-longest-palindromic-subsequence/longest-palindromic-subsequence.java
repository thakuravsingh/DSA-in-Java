class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        int i = 0;
        for(int j = 1; j < n; j++){
            int k = j;
            while(k < n){
                if(s.charAt(i) == s.charAt(k)) dp[i][k] = 2  + dp[i+1][k-1];
                else dp[i][k] = Math.max(dp[i+1][k],dp[i][k-1]);
                i++;
                k++;
            }
            i = 0;
        }
        return dp[0][n-1];
    }
}