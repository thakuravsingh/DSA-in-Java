class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int i = 0;
        int[] neg = new int[n/2];
        int j = 0;
        for(int k = 0; k < n; k++){
            if(nums[k] > 0) pos[i++] = nums[k];
            else neg[j++] = nums[k];
        }
        int[] ans = new int[n];
        i = 0;
        j = 0;
        for(int k = 0; k < n; k++){
            if(k % 2 == 0) ans[k] = pos[i++];
            else ans[k] = neg[j++];
        }
        return ans;
    }
}