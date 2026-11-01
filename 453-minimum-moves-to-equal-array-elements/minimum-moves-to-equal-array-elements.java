class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int count = 0;
        for(int i = 1; i < n; i++){
            count += (nums[i]-min);
        }
        return count;
    }
}