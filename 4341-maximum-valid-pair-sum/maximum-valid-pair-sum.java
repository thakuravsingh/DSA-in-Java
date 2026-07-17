class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n-k];
        int curMax = Integer.MIN_VALUE;
        int idx = max.length-1;
        for(int i = n - 1; i >= k; i--){
            curMax = Math.max(nums[i],curMax);
            max[idx--] = curMax;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n - k; i++){
            ans = Math.max(nums[i]+max[i],ans);
        }
        return ans;
    }
}