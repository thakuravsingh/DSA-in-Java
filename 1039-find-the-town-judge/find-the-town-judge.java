class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] mat = new int[n+1][n+1];
        for(int[] ele : trust){
            int a = ele[0];
            int b = ele[1];
            mat[b][a] = 1;
        }
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(mat[i][j] == 1) sum++;
            }
            if(sum == n - 1){
                for(int j = 1; j <= n; j++){
                    if(mat[i][j] == 1 && mat[j][i] == 1) return -1;
                }
                return i;
            }
        }
        return -1;
    }
}