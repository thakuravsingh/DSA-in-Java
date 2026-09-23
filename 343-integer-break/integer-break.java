class Solution {
    public int integerBreak(int n) {
        int[] nums = new int[n-1];
        for(int i = 0; i < nums.length; i++) nums[i] = i + 1;
        return maxProduct(nums,0,n);
    }
    public int maxProduct(int[] nums, int i, int tgt){
        if(tgt == 0) return 1;
        if(i == nums.length) return 1;
        int skip = maxProduct(nums,i+1,tgt);
        int pick = (tgt >= nums[i]) ? nums[i] * maxProduct(nums,i,tgt-nums[i]) : -(int)1e9;
        return Math.max(skip,pick);
    }
}