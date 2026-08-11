class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] == 1) sum += nums[i];
            else break;
        }
        int[] freq = new int[51];
        for(int i = 0; i < n; i++) freq[nums[i]]++;
        int ans = sum;
        while(true){
            if(ans > 50) return ans;
            if(freq[ans] > 0) ans++;
            else break;
        }
        return ans;
    }
}