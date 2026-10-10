class Solution {
    int mod = (int)1e9+7;
    public int countGoodNumbers(long n) {
        if(n == 1) return 5;
        if(n % 2 == 0) return (int)pow(20,n/2);
        else return (int)(pow(2,n/2-1) % mod * pow(10,n/2+1) % mod) % mod;
    }
    public long pow(long a, long b){
        if(b == 0) return 1;
        long half = pow(a,b/2);
        long res = (half % mod * half % mod) % mod;
        if(b % 2 != 0) res = (res % mod * a % mod) % mod;
        return res;
    }
}