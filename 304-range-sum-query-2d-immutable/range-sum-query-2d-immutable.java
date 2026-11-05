class NumMatrix {
    int[][] grid;
    int[][] prefix; 
    // prefix[i][j] : sum of all the elements lie in between rectangular region formed by (0,0) and (i,j)
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = matrix[i][j];
            }
        }
        prefix = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = grid[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = row1 + 1;
        int b = col1 + 1;
        int c = row2 + 1;
        int d = col2 + 1;
        return prefix[c][d] - prefix[a-1][d] - prefix[c][b-1] + prefix[a-1][b-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */