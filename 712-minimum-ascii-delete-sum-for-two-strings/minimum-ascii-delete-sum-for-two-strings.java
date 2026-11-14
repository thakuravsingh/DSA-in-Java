class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        return getMinSum(s1,s2,0,0);
    }
    public int getMinSum(String s1, String s2, int i, int j){
        int m = s1.length();
        int n = s2.length();
        if(i == m && j == n) return 0;
        if(i == m){
            int sum = 0;
            while(j < n){
                sum += s2.charAt(j);
                j++;
            }
            return sum;
        }
        if(j == n){
            int sum = 0;
            while(i < m){
                sum += s1.charAt(i);
                i++;
            }
            return sum;
        }
        if(dp[i][j] != -1) return dp[i][j];
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        if(ch1 == ch2) return dp[i][j] = getMinSum(s1,s2,i+1,j+1);
        else return dp[i][j] = Math.min(ch1+getMinSum(s1,s2,i+1,j),ch2+getMinSum(s1,s2,i,j+1));
    }
}