class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] < k) return 1;
            else return 0;
        }
        int product = 1;
        int ans = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            product *= nums[i];
            while(product >= k){
                product /= nums[j];
                j++;
            }
            ans += (i-j+1);
        }
        return ans;
    }
}