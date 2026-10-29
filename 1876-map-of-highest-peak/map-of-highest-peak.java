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
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1) height[i][j] = 0;
                else height[i][j] = -1; // indicates unVisited
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(height[i][j] == 0){
                    for(int k = 0; k < 4; k++){
                        int newR = i + dir[k][0];
                        int newC = j + dir[k][1];
                        if(newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                        if(height[newR][newC] == -1) height[newR][newC] = 1;
                    }
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(height[i][j] == 1) q.add(new Pair(i,j)); // MutliSource BFS
            }
        }
        int curHeight = 2;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair front = q.remove();
                int row = front.row;
                int col = front.col;
                for(int k = 0; k < 4; k++){
                    int newR = row + dir[k][0];
                    int newC = col + dir[k][1];
                    if(newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                    if(height[newR][newC] == -1) {
                        height[newR][newC] = curHeight;
                        q.add(new Pair(newR,newC));
                    }
                }
            }
            curHeight++;
        }
        return height;
    }
}