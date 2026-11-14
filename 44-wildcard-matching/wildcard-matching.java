class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new Boolean[m+1][n+1];
        return getAns(s,p,0,0);
    }
    public boolean getAns(String s, String p, int i, int j){
        int m = s.length();
        int n = p.length();
        if(j == n) return i == m;
        if(dp[i][j] != null) return dp[i][j];
        boolean first = false;
        if(i < m && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?' || p.charAt(j) == '*')) first = true;
        if(j < n && p.charAt(j) == '*'){
            boolean skip = getAns(s,p,i,j+1);
            boolean pick = first && getAns(s,p,i+1,j);
            return dp[i][j] = skip || pick;
        }
        else {
            return dp[i][j] = first && getAns(s,p,i+1,j+1);
        }
    }
}