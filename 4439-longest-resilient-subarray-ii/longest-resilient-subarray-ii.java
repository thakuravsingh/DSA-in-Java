class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        int len = 1;
        int sum = nums[0] % k;
        for(int i = 1; i < n; i++){
            if(nums[i] % k == nums[i-1] % k){
                len++;
                sum = (sum + nums[i] % k) % k;
            }
            else{
                len = 1;
                sum = nums[i] % k;
            }
            if(sum == nums[i] % k) ans = Math.max(ans,len);
        }
        return ans;
    }
}