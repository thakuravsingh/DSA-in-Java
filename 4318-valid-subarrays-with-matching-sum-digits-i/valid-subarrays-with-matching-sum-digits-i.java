class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            long curSum = 0;
            for(int j = i; j < n; j++){
                curSum += nums[j];
                long last = curSum % 10;
                long first = 0;
                long num = curSum;
                while(num != 0){
                    first = num % 10;
                    num /= 10;
                }
                if(first == x && last == x) ans++;
            }
        }
        return ans;
    }
}