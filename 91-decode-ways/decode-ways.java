class Solution {
    int[] dp;
    public int fxn(String s, int i){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int first = fxn(s,i+1);
        int sec = 0;
        if(i < s.length() - 1) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num <= 26) sec = fxn(s, i + 2);
        }
        return dp[i] = first + sec;
    }
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        return fxn(s,0);
    }
}