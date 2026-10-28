class Solution {
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        return getMaxDotProduct(nums1,nums2,0,0);
    }
    public int getMaxDotProduct(int[] nums1, int[] nums2, int i, int j){
        int m = nums1.length;
        int n = nums2.length;
        if(i == m || j == n) return -(int)1e9;
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int curProduct = nums1[i] * nums2[j];
        int pick = curProduct + getMaxDotProduct(nums1,nums2,i+1,j+1);
        int skip1 = getMaxDotProduct(nums1,nums2,i+1,j);
        int skip2 = getMaxDotProduct(nums1,nums2,i,j+1);
        return dp[i][j] = Math.max(curProduct,Math.max(pick,Math.max(skip1,skip2)));
    }
}