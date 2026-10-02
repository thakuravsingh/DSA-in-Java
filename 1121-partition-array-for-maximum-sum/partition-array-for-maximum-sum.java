class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return getMaxSum(arr,k,0);
    }
    public int getMaxSum(int[] arr,int k,int i){
        int n = arr.length;
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int curMax = arr[i];
        int ans = arr[i];
        for(int j = 1; j <= k && i+j-1 < n; j++){
            curMax = Math.max(curMax,arr[i+j-1]);
            ans = Math.max(ans,j * curMax + getMaxSum(arr,k,i+j));
        }
        return dp[i] = ans;
    }
}