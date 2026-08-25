class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[101];
        for(int i = 0; i < n; i++){
            if(nums[i] % k == 0) freq[nums[i]/k]++;
        }
        int ans = 0;
        for(int i = 1; i <= 100; i++) {
            if(freq[i] == 0){
                ans = i * k;
                break;
            }
        }
        return ans == 0 ? 101 * k : ans;
    }
}