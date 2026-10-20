class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefix = new long[n];
        prefix[0] = prices[0] * strategy[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] + prices[i] * strategy[i];
        long ans = prefix[n-1];
        int i = 0;
        int j = k - 1;
        long sum = 0;
        for(int idx = k / 2; idx <= j; idx++) sum += prices[idx];
        ans = Math.max(ans,sum+prefix[n-1]-prefix[j]);
        i++;
        j++;
        while(j < n){
            sum = sum - prices[j-k/2] + prices[j];
            ans = Math.max(ans,sum+prefix[n-1]-prefix[j]+prefix[i-1]);
            i++;
            j++;
        }
        return ans;
    }
}