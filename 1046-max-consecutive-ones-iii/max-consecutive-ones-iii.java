class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        int maxLen = 0;
        while(j < n && (nums[j] == 1 || k > 0)){
            if(nums[j] == 0) k--;
            j++;
        }
        maxLen = Math.max(maxLen,j-i);
        while(j < n){
            if(nums[i] == 0) k++;
            i++;
            while(j < n && (nums[j] == 1 || k > 0)){
                if(nums[j] == 0) k--;
                j++;
            }
            maxLen = Math.max(maxLen,j-i);
        }
        return maxLen;
    }
}