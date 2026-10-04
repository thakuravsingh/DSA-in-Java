class Solution {
    Boolean[][][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n+1][n/2+1][n/2+1];
        return fxn(s,0,0,0);
    }
    public boolean fxn(String s, int i, int open, int close){
        int n = s.length();
        if(close > open || open > (n/2)) return false;
        if(i == n) return open == close;
        if(dp[i][open][close] != null) return dp[i][open][close];
        char ch = s.charAt(i);
        if(ch == '(') return dp[i][open][close] = fxn(s,i+1,open+1,close);
        else if(ch == ')') return dp[i][open][close] = fxn(s,i+1,open,close+1);
        else{
            boolean left = fxn(s,i+1,open+1,close);
            boolean right = fxn(s,i+1,open,close+1);
            boolean nothing = fxn(s,i+1,open,close);
            return dp[i][open][close] = left || right || nothing;
        }
    }
}