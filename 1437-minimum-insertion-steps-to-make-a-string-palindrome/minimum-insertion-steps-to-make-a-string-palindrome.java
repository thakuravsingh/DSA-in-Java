class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        return getAns(s,0,n-1);
    }
    public int getAns(String s, int i, int j){
        if(i >= j) return 0;;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return getAns(s,i+1,j-1);
        else return dp[i][j] = 1 + Math.min(getAns(s,i+1,j),getAns(s,i,j-1));
    }
}