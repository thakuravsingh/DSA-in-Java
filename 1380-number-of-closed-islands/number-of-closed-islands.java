class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int j = 0; j < n; j++){
            if(!vis[0][j] && grid[0][j] == 0) bfs(grid,vis,0,j);
            if(!vis[m-1][j] && grid[m-1][j] == 0) bfs(grid,vis,m-1,j);
        }
        for(int i = 1; i < m - 1; i++){
            if(!vis[i][0] && grid[i][0] == 0) bfs(grid,vis,i,0);
            if(!vis[i][n-1] && grid[i][n-1] == 0) bfs(grid,vis,i,n-1);
        }
        int ans = 0;
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(!vis[i][j] && grid[i][j] == 0){
                    bfs(grid,vis,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] grid, boolean[][] vis, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col] = true;
        while(!q.isEmpty()){
            Pair front = q.remove();
            for(int i = 0; i < 4; i++){
                int newR = front.row + dir[i][0];
                int newC = front.col + dir[i][1];
                if(newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                if(!vis[newR][newC] && grid[newR][newC] == 0){
                    q.add(new Pair(newR,newC));
                    vis[newR][newC] = true;
                }
            }
        }
    }
}