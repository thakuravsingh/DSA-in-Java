class Solution {
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i],-1);
        return getMax(nums1,nums2,m-1,n-1);
    }
    public int getMax(int[] nums1, int[] nums2, int i, int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(nums1[i] == nums2[j]) return dp[i][j] = 1 + getMax(nums1,nums2,i-1,j-1);
        else return dp[i][j] = Math.max(getMax(nums1,nums2,i-1,j),getMax(nums1,nums2,i,j-1));
    }
}