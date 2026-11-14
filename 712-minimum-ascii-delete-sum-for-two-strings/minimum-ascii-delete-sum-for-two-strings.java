class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
//        dp[i][j] = lowest ascii sum of the deleted characters till first i characters of s1 and first j characters of s2.
        int[][] dp = new int[m+1][n+1];
//        initialisation.
        int sum = 0;
        for(int i = 1; i <= m; i++){
            sum += s1.charAt(i-1);
            dp[i][0] = sum;
        }
        sum = 0;
        for(int j = 1; j <= n; j++){
            sum += s2.charAt(j-1);
            dp[0][j] = sum;
        }
//        State transition.
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j],s2.charAt(j-1)+dp[i][j-1]);
            }
        }
//        final answer.
        return dp[m][n];
    }
}