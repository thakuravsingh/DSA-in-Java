class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    public long pow(int a, int b){
        if(b == 0) return 1;
        if(b == 1) return a;
        long ans = pow(a,b/2);
        if(b % 2 == 0) return ans * ans;
        else return a * ans * ans;

    }
    public int fxn(long[] nums, int idx, int target){
        int n = nums.length;
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(idx >= n) return 0;
        if(dp[idx][target] != -1) return dp[idx][target];
        long sum = 0;
        for(int i = idx; i < n; i++){
            if(nums[i] > target) break;
            long a = fxn(nums,i+1,(int)(target-nums[i]));
            sum = (sum + a) % mod;
        }
        return dp[idx][target] = (int)sum;
    }
    public int numberOfWays(int n, int x) {
        long[] nums = new long[n+1];
        for(int i = 1; i <= n; i++){
            long val = pow(i, x);
            if(val > n) break;
            nums[i] = val;
        }
        dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);;
        return fxn(nums,1,n);
    }
}