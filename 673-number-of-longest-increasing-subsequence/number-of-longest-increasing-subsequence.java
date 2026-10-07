class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] temp = new int[n];
        Arrays.fill(temp,1);
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 0;
        for(int ele : dp) max = Math.max(ele,max);
        for(int i = 1; i < n; i++){
            int count = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j] && dp[j] == dp[i] - 1) count += temp[j]; 
            }
            if(count != 0) temp[i] = count;
        }
        int res = 0;
        for(int i = 0; i < n; i++) if(dp[i] == max) res += temp[i];
        return res;
    }
}