class Solution {
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0] != 1) return false;
        int n = stones.length;
        dp = new Boolean[n+1][2001];
        return helper(1,1,stones);
    }
    public boolean helper(int i, int j, int[] stones){
        int n = stones.length;
        if(i == n - 1) return true;
        if(dp[i][j] != null) return dp[i][j];
        boolean a = false,b = false,c = false;
        if(j != 1){
            boolean flag = false;
            int idx;
            for(idx = i + 1; idx < n; idx++) {
                if(stones[idx] == stones[i] + j - 1){
                    flag = true;
                    break;
                }
                else if(stones[idx] > stones[i] + j - 1) break;
            }
            if(flag) a = helper(idx,j-1,stones);
        }
        boolean flag = false;
        int idx;
        for(idx = i + 1; idx < n; idx++) {
            if(stones[idx] == stones[i] + j){
                flag = true;
                break;
            }
            else if(stones[idx] > stones[i] + j) break;
        }
        if(flag) b = helper(idx,j,stones);
        flag = false;
        for(idx = i + 1; idx < n; idx++) {
            if(stones[idx] == stones[i] + j + 1){
                flag = true;
                break;
            }
            else if(stones[idx] > stones[i] + j + 1) break;
        }
        if(flag) c = helper(idx,j+1,stones);
        return dp[i][j] = a || b || c;
    }
}