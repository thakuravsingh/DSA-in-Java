class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int getMax(int[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        int max = 0;
        for(int idx = 0; idx < 4; idx++){
            int newR = i + dir[idx][0];
            int newC = j + dir[idx][1];
            if(newR < 0 || newR >= m || newC < 0 || newC >= n) continue;
            if(!vis[newR][newC] && grid[newR][newC] != 0){
                max = Math.max(max,getMax(grid,vis,newR,newC));
            }
        }
        vis[i][j] = false;
        return max + grid[i][j];
    }
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boolean[][] vis = new boolean[m][n];
                if(grid[i][j] != 0) ans = Math.max(ans,getMax(grid,vis,i,j));
            }
        }
        return ans;
    }
}