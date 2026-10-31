class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) ans = Math.max(ans,dfs(grid,i,j));
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int r = dfs(grid,i,j+1);
        int d = dfs(grid,i+1,j);
        int l = dfs(grid,i,j-1);
        int u = dfs(grid,i-1,j);
        return 1 + r + d + l + u;
    }
}