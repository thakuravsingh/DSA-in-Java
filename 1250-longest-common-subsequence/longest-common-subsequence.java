class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        return getMaxLength(s1,s2,m-1,n-1);
    }
    public int getMaxLength(String s1, String s2, int i, int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + getMaxLength(s1,s2,i-1,j-1);
        else return dp[i][j] = Math.max(getMaxLength(s1,s2,i-1,j),getMaxLength(s1,s2,i,j-1));
    }
}