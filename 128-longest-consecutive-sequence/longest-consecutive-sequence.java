class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int maxLength = 1;
        int cur = 1;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] == prev + 1) {
                cur++;
                prev = nums[i];
            }
            else if(nums[i] == prev) continue;
            else{
                maxLength = Math.max(maxLength,cur);
                prev = nums[i];
                cur = 1;
            }
        }
        maxLength = Math.max(maxLength,cur);
        return maxLength;
    }
}