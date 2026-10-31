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
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) ans = Math.max(ans,bfs(grid,i,j));
            }
        }
        return ans;
    }
    public int bfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j] = 0;
        int ans = 1;
        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            for(int idx = 0; idx < 4; idx++){
                int newR = row + dir[idx][0];
                int newC = col + dir[idx][1];
                if(newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                if(grid[newR][newC] == 1){
                    q.add(new Pair(newR,newC));
                    grid[newR][newC] = 0;
                    ans++;
                }
            }
        }
        return ans;
    }
}