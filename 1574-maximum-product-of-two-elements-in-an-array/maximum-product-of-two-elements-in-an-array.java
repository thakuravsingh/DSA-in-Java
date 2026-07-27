class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = 0;
        int max_id = -1;
        int sec = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > max) {
                max = nums[i];
                max_id = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > sec && i != max_id) sec = nums[i];
        }
        return (max-1) * (sec-1);
    } 
}