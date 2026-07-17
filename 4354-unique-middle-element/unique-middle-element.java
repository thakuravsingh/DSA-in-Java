class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        int mid = nums[n / 2];
        for(int i = 0; i < n; i++){
            if(i != n / 2 && mid == nums[i]) return false;
        }
        return true;
    }
}