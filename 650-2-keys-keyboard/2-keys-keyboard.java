class Solution {
    public int minSteps(int n) {
        return minOp(n,0,1,-1);
    }
    public int minOp(int n, int copy,int tot, int state){
        if(n == tot) return 0;
        if(n < tot) return (int)1e9+7;
        int a = state != 0 ? 1 + minOp(n,tot,tot,0) : (int)1e9+7;
        int b = state != -1 ? 1 + minOp(n,copy,tot+copy,1) : (int)1e9+7;
        return Math.min(a,b);
    }
}