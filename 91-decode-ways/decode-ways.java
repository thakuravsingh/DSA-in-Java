class Solution {
    int[] dp;
    public int fxn(String s, int i){
        if(i == s.length() - 1){
            if(s.charAt(i) != '0') return 1;
            else return 0;
        }
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        String temp = "";
        temp += s.charAt(i);
        temp += s.charAt(i+1);
        int num = Integer.parseInt(temp);
        int first = fxn(s,i+1);
        int sec = 0;
        if(num <= 26) sec = fxn(s,i+2);
        return dp[i] = first + sec;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int n = s.length();
        for(int i = 0; i < n - 1; i++) if(s.charAt(i) == '0' && s.charAt(i+1) == '0') return 0;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return fxn(s,0);
    }
}