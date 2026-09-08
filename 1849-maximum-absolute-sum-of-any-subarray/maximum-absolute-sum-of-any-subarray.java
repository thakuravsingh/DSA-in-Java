class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int curr = nums[0];
        int max = nums[0];
        for(int j = 1; j < n; j++){
            curr = Math.max(nums[j],curr+nums[j]);
            max = Math.max(curr,max);
        }
        curr = nums[0];
        int min = nums[0];
        for(int j = 1; j < n; j++){
            curr = Math.min(nums[j],curr+nums[j]);
            min = Math.min(curr,min);
        }
        return Math.max(max,Math.abs(min));
    }
}