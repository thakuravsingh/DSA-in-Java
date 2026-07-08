class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int count = 0 ; count < n; count++){
            int i = 0;
            int j = count;
            while(j < n){
                if(i == j) dp[i][j] = 1;
                else if((i - j == -1) && s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) dp[i][j] = 1;
                i++;
                j++;
            }
        }
        for(int count = n - 1; count >= 0; count--){
            int i = 0;
            int j = count;
            while(j < n){
                if(dp[i][j] == 1) return s.substring(i,j+1);
                i++;
                j++;
            }
        }
        return "";
    }
}