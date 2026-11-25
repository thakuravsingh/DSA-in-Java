class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] mat = new int[n][n];
        for(int[] edge : roads){
            int u = edge[0];
            int v = edge[1];
            mat[u][v] = 1;
            mat[v][u] = 1;
        }
        int max = -1;
        for(int i = 0; i < n - 1; i++){
            int sum = 0;
            for(int j = 0; j < n; j++) if(mat[i][j] == 1) sum++;
            for(int j = i + 1; j < n; j++){
                int curSum = sum;
                for(int k = 0; k < n; k++){
                    if(mat[j][k] == 1) curSum++;
                }
                if(mat[i][j] == 1 && mat[j][i] == 1) curSum--;
                max = Math.max(curSum,max);
            }
        }
        return max;
    }
}