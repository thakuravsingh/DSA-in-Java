class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int j = 0;
        long product = 1;
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            product = (i-j+1) * sum;
            while(product >= k){
                sum -= nums[j];
                j++;
                product = (i-j+1) * sum;
            }
            ans += (i-j+1);
        }
        return ans;
    }
}