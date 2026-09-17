class Solution {
    int[] ones;
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        ones = new int[len];
        for(int i = 0; i < len; i++){
            int count = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '1') count++;
            }
            ones[i] = count;
        }
        dp = new int[len][m+1][n+1];
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxSubarray(strs,0,m,n);
    }
    public int maxSubarray(String[] strs, int i, int m, int n){
        if(i == strs.length) return 0;
        if(dp[i][m][n] != -1) return dp[i][m][n];
        int one = ones[i];
        int zero = strs[i].length()-one;
        int skip = maxSubarray(strs,i+1,m,n);
        int pick = (m >= zero && n >= one) ? 1  + maxSubarray(strs,i+1,m-zero,n-one) : -(int)1e9;
        return dp[i][m][n] = Math.max(skip,pick);

    }
}