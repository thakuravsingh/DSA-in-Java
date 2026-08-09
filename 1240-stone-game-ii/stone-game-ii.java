class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][2][n+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,1,piles,1,dp);
    }
    public int helper(int i, int person, int[] piles, int M, int[][][] dp){
        int n = piles.length;
        if(i >= n) return 0;
        if(dp[i][person][M] != -1) return dp[i][person][M];
        int stone = 0;
        int res = (person == 1) ? -1 : Integer.MAX_VALUE;
        for(int x = 1; x <= Math.min(2 * M, n - i); x++){
            if((i+x-1) < n) stone += piles[i+x-1];
            if(person == 1) res = Math.max(res, stone + helper(i+x,0,piles,Math.max(M,x),dp));
            else res = Math.min(res, helper(i+x,1,piles,Math.max(M,x),dp));
        }
        return dp[i][person][M] = res;
    }
}