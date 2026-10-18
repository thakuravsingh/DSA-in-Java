class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            int mod = nums[i] % k;
            for(int j = i; j < n; j++){
                if(nums[j] % k != mod) break;
                sum += nums[j];
                if(sum % k == mod &&  nums[j] % k == mod) ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}