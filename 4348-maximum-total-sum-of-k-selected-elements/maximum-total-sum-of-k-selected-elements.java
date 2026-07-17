class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        for(int i = n - 1; k > 0; i--){
            if(mul > 0) sum += ((long)nums[i] * (long)mul);
            else sum += (long)nums[i];
            mul--;
            k--;
        }
        return sum;
    }
}