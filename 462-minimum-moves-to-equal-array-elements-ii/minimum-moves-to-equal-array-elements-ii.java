class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int ele : nums) count += Math.abs(ele-nums[n/2]);
        return count;
    }
}