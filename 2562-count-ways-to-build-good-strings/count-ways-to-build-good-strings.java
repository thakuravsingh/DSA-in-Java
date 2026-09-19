class Solution {
    int[] dp;
    int mod = (int)1e9+7;
    public int countGoodStrings(int lo, int hi, int zero, int one) {
        dp = new int[(int)1e5+1];
        Arrays.fill(dp,-1);
        return count(lo,hi,zero,one,0);
    }
    public int count(int lo, int hi, int zero, int one, int len){
        if(len > hi) return 0;
        if(dp[len] != -1) return dp[len]; 
        long pickZero = (len+zero >= lo && len+zero <= hi) ? 1 : 0;
        pickZero = (pickZero + count(lo,hi,zero,one,len+zero)) % mod;
        long pickOne = (len+one >= lo && len+one<= hi) ? 1 : 0;
        pickOne = (pickOne + count(lo,hi,zero,one,len+one)) % mod;
        return dp[len] = (int)((pickOne + pickZero) % mod);
    }
}