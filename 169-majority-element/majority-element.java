class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int freq = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) freq++;
            else freq = 1;
            if(freq > (nums.length/2)) return nums[i];
        }
        return nums[0];
    }
}