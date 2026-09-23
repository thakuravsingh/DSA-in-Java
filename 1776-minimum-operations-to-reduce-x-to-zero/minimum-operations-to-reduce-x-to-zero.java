class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum == x) return n;
        if(sum < x) return -1;
        int remSum = sum-x;
        int maxLen = -1;
        int curSum = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            curSum += nums[i];
            while (curSum > remSum) {
                curSum -= nums[j];
                j++;
            }
            if (curSum == remSum) maxLen = Math.max(maxLen, i - j + 1);
        }
        if(maxLen == -1) return -1;
        return n - maxLen;
    }
}