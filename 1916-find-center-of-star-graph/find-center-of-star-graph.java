class Solution {
    public int findCenter(int[][] edges) {
        int common = -1;
        for(int i = 0; i < 2; i++){
            int node = edges[0][i];
            for(int j = 0; j < 2; j++){
                if(edges[1][j] == node){
                    common = node;
                    break;
                }
            }
        }
        return common;
    }
}