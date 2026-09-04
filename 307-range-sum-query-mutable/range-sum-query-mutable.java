class NumArray {
    int n;
    int[] st;
    public NumArray(int[] nums) {
        n = nums.length;
        st = new int[4*n];
        build(0,n-1,0,nums);
    }
    public void update(int index, int val) {
        updateQuery(index,val,0,n-1,0);
    }
    public int sumRange(int left, int right) {
        return getSum(left,right,0,n-1,0);
    }
    public void build(int lo, int hi, int idx, int[] nums){
        if(lo == hi){
            st[idx] = nums[lo];
            return;
        }
        int mid = lo + (hi-lo) / 2;
        build(lo,mid,2*idx+1,nums);
        build(mid+1,hi,2*idx+2,nums);
        st[idx] = st[2*idx+1] + st[2*idx+2];
    }
    public void updateQuery(int i, int val, int lo, int hi, int idx){
        if(lo == hi){
            st[idx] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(mid >= i) updateQuery(i,val,lo,mid,2*idx+1);
        else updateQuery(i,val,mid+1,hi,2*idx+2);
        st[idx] = st[2*idx+1] + st[2*idx+2];
    }
    public int getSum(int l, int r, int lo, int hi, int idx) {
        if(r < lo || hi < l) return 0;
        if(l <= lo && r >= hi) return st[idx];
        int mid = lo + (hi - lo) / 2;
        int left = getSum(l,r,lo,mid,2*idx+1);
        int right = getSum(l,r,mid+1,hi,2*idx+2);
        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */