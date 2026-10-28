class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = (int)1e9+7;
        long[][] dp = new long[n][n]; 
        for(int i = 0; i < n; i++) dp[i][i] = 1; 
        for(int idx = 1; idx < n; idx++){
            int i = 0;
            int j = idx;
            while(j <  n){
                if(s.charAt(i) == s.charAt(j)){
                    int lo = i + 1;
                    int hi = j - 1;
                    while(lo <= hi && s.charAt(i) != s.charAt(lo)) lo++;
                    while(lo <= hi && s.charAt(j) != s.charAt(hi)) hi--;
                    if(lo > hi) dp[i][j] = 2 * dp[i+1][j-1] + 2;
                    else if(lo == hi) dp[i][j] = 2 * dp[i+1][j-1] + 1;
                    else dp[i][j] = 2 * dp[i+1][j-1] - dp[lo+1][hi-1];
                }
                else dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                dp[i][j] = (dp[i][j] + mod) % mod;
                i++;
                j++;
            }
        }
        return (int)dp[0][n-1];
    }
}