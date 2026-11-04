class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int gap = 1; gap < n; gap++){
            for(int i = 0; i + gap < n; i++){
                int j = gap + i;
                if(s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else{
                    if(j - i == 1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = (int)1e9;
            if(dp[0][i]) ans[i] = 0;
            else{
                for(int j = 1; j <= i; j++){
                    if(dp[j][i]) ans[i] = Math.min(ans[i],1+ans[j-1]);
                }
            }
        }
        return ans[n-1];
    }
}