class Solution {
    public int isSquare(int n){
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0 && n / i == i) return i;
        }
        return -1;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) dp[i][0] = matrix[i][0]-'0';
        for(int j = 1; j < n; j++) dp[0][j] = matrix[0][j]-'0';
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = matrix[i][j]-'0';
                if(dp[i][j] > 0){
                    int up = isSquare(dp[i-1][j]);
                    int left = isSquare(dp[i][j-1]);
                    int dia = isSquare(dp[i-1][j-1]);
                    if(up != -1 &&  left != -1 &&  dia != -1){
                        int min = Math.min(up,Math.min(left,dia));
                        dp[i][j] = (min+1) * (min + 1);
                    }
                }
            }
        } 
        int max = 0;
        for(int[] ele : dp){
            for(int val : ele) max = Math.max(val,max);
        }
        return max;
    }
}