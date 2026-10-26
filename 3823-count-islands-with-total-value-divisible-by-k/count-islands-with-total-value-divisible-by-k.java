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
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] != 0){
                    if(bfs(grid,vis,i,j,k) == 0) ans++;
                }
            }
        }
        return ans;
    }
    public int bfs(int[][] grid, boolean[][] vis, int row, int col, int k){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col] = true;
        int sum = grid[row][col]%k;
        while(!q.isEmpty()){
            Pair front = q.remove();
            for(int i = 0; i < 4; i++){
                int newR = front.row + dir[i][0];
                int newC = front.col + dir[i][1];
                if(newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                if(!vis[newR][newC] && grid[newR][newC] != 0){
                    q.add(new Pair(newR,newC));
                    vis[newR][newC] = true;
                    sum = (sum + grid[newR][newC]) % k;
                }
            }
        }
        return sum;
    }
}