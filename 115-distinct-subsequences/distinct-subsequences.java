class Solution {
    int[][] dp;
    public int fxn(String s, String t, String sb, int i, int j){
        if(t.length() == sb.length()){
            if(t.equals(sb)) return 1;
            else return 0;
        }
        if(i == s.length() || j == t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a = 0;
        int b = 0;
        int c = 0;
        if(s.charAt(i) == t.charAt(j)){
            b = fxn(s,t,sb+s.charAt(i),i+1,j+1);
            a = fxn(s,t,sb,i+1,j);
        }
        else c = fxn(s,t,sb,i+1,j);
        return dp[i][j] = a+b+c;
    }
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        if(m > n) return 0;
        dp = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
        String sb = "";
        return fxn(s,t,sb,0,0);
    }
}