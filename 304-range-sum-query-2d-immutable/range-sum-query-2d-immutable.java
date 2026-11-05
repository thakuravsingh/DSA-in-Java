class NumMatrix {
    int[][] grid;
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = matrix[i][j];
            }
        }
        prefix = new int[m][n];
        for(int i = 0; i < m; i++){
            prefix[i][0] = grid[i][0];
            for(int j = 1; j < n; j++){
                prefix[i][j] = prefix[i][j-1] + grid[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 != 0) sum += prefix[i][col2] - prefix[i][col1-1];
            else sum += prefix[i][col2];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */