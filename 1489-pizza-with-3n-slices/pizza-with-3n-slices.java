class Solution {
    int[][] dp;
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int toSelect = n / 3;
        dp = new int[501][168];
        for(int i = 0; i <= 500; i++) Arrays.fill(dp[i],-1);
        int first = getMax(slices,0,n-1,toSelect);
        for(int i = 0; i <= 500; i++) Arrays.fill(dp[i],-1);
        int sec = getMax(slices,1,n,toSelect);
        return Math.max(first,sec);
    }
    public int getMax(int[] slices, int i, int n, int count){
        if(count == 0) return 0;
        if(i >= n) return -(int)1e6;
        if(dp[i][count] != -1) return dp[i][count];
        int skip = getMax(slices,i+1,n,count);
        int pick = slices[i] + getMax(slices,i+2,n,count-1);
        return dp[i][count] = Math.max(pick,skip);
    }
}