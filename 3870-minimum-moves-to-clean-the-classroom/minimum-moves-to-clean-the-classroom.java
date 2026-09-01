class Solution {
    class State{
        int x;
        int y;
        int e;
        int mask;
        State(int x, int y, int e, int mask){
            this.x = x;
            this.y = y;
            this.e = e;
            this.mask = mask;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] grid = new char[m][n];
        int sr=0,sc=0;
        int[][] litterpstn = new int[m][n];
        int pstn = 0;
        int litter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char ch = classroom[i].charAt(j);
                if(ch == 'S') {
                    sr = i;
                    sc = j;
                } else if(ch == 'L'){
                    litterpstn[i][j] = pstn++;
                    litter++;
                }
                grid[i][j] = ch;
            }
        }
        if(litter == 0) return 0;
        int totalmask = (1 << litter) - 1;
        boolean[][][][] isVis = new boolean[m][n][energy+1][1 << litter];
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<State> q = new LinkedList<>();
        q.add(new State(sr,sc,energy,0));
        isVis[sr][sc][energy][0] = true;
        int moves = 0;
        int capacity = energy;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 1; i <= size; i++){
                State front = q.remove();
                if(front.mask == totalmask) return moves;
                int r = front.x;
                int c = front.y;
                int e = front.e;
                e--;
                if(e < 0) continue;
                int curr = front.mask;
                for(int d = 0; d < 4; d++) {
                    int newRow = r + dir[d][0];
                    int newCol = c + dir[d][1];
                    if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
                    if(grid[newRow][newCol] == 'X') continue;
                    int newmask = curr;
                    int newenergy = e;
                    if(grid[newRow][newCol] == 'L'){
                        int k = litterpstn[newRow][newCol];
                        newmask |= (1 << k);
                    }
                    if(grid[newRow][newCol] == 'R') newenergy = capacity;
                    if(!isVis[newRow][newCol][newenergy][newmask]) {
                        q.add(new State(newRow, newCol,newenergy,newmask));
                        isVis[newRow][newCol][newenergy][newmask] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}