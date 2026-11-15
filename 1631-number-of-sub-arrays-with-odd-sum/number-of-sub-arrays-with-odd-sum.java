class Solution {
    int mod = (int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] + arr[i];
        int even = 1;
        int odd = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            // even + odd = odd
            if(prefix[i] % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            }
            // odd + even = odd
            else{
                ans = (ans + even) % mod;
                odd++;
            }
        }
        return ans;
    }
}