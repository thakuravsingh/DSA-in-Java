class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }
        int max = 0;
        for(int ele : dp) max = Math.max(ele,max);
        return max;
    }
}