class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int a = (i - k >= 0) ? i - k: 0;
                int b = (j - k >= 0) ? j - k: 0;
                int c = (i + k < m) ? i + k: m-1;
                int d = (j + k < n) ? j + k: n-1;
                a++;
                b++;
                c++;
                d++;
                answer[i][j] = prefix[c][d] - prefix[a-1][d] - prefix[c][b-1] + prefix[a-1][b-1]; 
            }
        }
        return answer;
    }
}