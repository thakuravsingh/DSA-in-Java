class Solution {
    long[] sumst;
    long[] sumsqst;
    long[] lazy;
    int[] lastSeenIdx;
    int mod = (int)1e9+7;
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        sumst = new long[4*n];
        sumsqst = new long[4*n];
        lazy = new long[4*n];
        lastSeenIdx = new int[(int)1e5+1];
        Arrays.fill(lastSeenIdx,-1);
        long ans = 0;
        for(int i = 0; i < n; i++){
            int l = lastSeenIdx[nums.get(i)] + 1;
            int r = i;
            updateRange(l,r,0,0,n-1,1);
            ans = (ans + sumsqst[0])  % mod;
            lastSeenIdx[nums.get(i)] = i;
        }
        return (int)ans;
    }
    public void updateRange(int l, int r, int i, int lo, int hi, long val){
        if(lazy[i] != 0){
            lazyAddition(lo,hi,i,lazy[i]);
            if(lo != hi){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        if(lo > r || l > hi) return;
        if(lo >= l && hi <= r){
            lazyAddition(lo,hi,i,val);
            if(lo != hi){
                lazy[2*i+1] += val;
                lazy[2*i+2] += val;
            }
            return;
        }
        int mid = lo + (hi - lo) / 2;
        updateRange(l,r,2*i+1,lo,mid,val);
        updateRange(l,r,2*i+2,mid+1,hi,val);
        sumst[i] = (sumst[2*i+1] + sumst[2*i+2]);
        sumsqst[i] = sumsqst[2*i+1] + sumsqst[2*i+2];
    }
    public void lazyAddition(int lo, int hi, int i, long val){
        long ele = hi - lo + 1;
        sumsqst[i] = (sumsqst[i] + (2 * (val*sumst[i]) % mod) % mod + (ele * (val*val) % mod) % mod) % mod;
        sumst[i] = (sumst[i] + (ele*val) % mod) % mod;
    }
}