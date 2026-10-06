class Solution {
    int mod = (int)1e9+7;
    public int countGoodStrings(long n) {
        if(n == 1 || n == 2) return (int)2;
        long[][] T = {{1,1},{1,0}};
        long[][] fn = {{2},{2}};
        long[][] ans = matrixMul(solve(T,n-2),fn);
        return (int)ans[0][0];
    }
    public long[][] solve(long[][] a, long b){
        if(b == 0) {
            long[][] ans = {{1,0},{0,1}};
            return ans;
        }
        long[][] half = solve(a,b/2);
        long[][] res = matrixMul(half,half);
        if(b % 2 != 0){
            res = matrixMul(res,a);
        }
        return res;
    }
    public long[][] matrixMul(long[][] a, long[][] b){
        int m = a.length;
        int n = a[0].length;
        int p = b.length;
        int q = b[0].length;
        long[][] c = new long[m][q];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < q; j++){
                for(int k = 0; k < n; k++){
                    c[i][j] = (c[i][j] + (a[i][k] * b[k][j]) % mod) % mod;
                }
            }
        }
        return c;
    }
}