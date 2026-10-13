class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);
        int[] dup = new int[n];
        int i = 0;
        int j = n - 1; 
        for(int k = 0; k < n; k++){
            if(k % 2 == 0) dup[k] = nums[j--];
            else dup[k] = nums[i++];
        }
        long ans = 0;
        for(int k = 0; k < n; k++){
            if(k % 2 == 0) ans = ans + (dup[k]*dup[k]);
            else ans = ans - (dup[k] * dup[k]);
        }
        return ans;
    }
}