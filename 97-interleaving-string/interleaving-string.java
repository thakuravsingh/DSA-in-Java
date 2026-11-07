class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        dp = new Boolean[m+1][n+1];
        return ans(s1,s2,s3,0,0);
    }
    public boolean ans(String s1, String s2, String s3, int i, int j){
        int m = s1.length();
        int n = s2.length();
        if(i + j >= s3.length()) return i == m && j == n;
        if(dp[i][j] != null) return dp[i][j];
        int k = i + j;
        boolean left = false;
        boolean right = false;
        if(i < m && s1.charAt(i) == s3.charAt(k)) left = ans(s1,s2,s3,i+1,j);
        if(j < n && s2.charAt(j) == s3.charAt(k)) right = ans(s1,s2,s3,i,j+1);
        return dp[i][j] = left || right;
    }
}