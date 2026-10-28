class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // lps between i and j
        for(int i = 0; i < n; i++) dp[i][i] = 1; // intialisation
        for(int idx = 1; idx < n; idx++){
            int i = 0;
            int j = idx;
            while(j <  n){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                i++;
                j++;
            }
        }
        return dp[0][n-1];
    }
}