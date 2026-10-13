class NumArray {
    int[] nums;
    int[] st;
    public NumArray(int[] arr) {
        int n = arr.length;
        nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = arr[i];
        st = new int[4*n];
        build(0,0,n-1);
    }
    public void update(int index, int val) {
        int n = nums.length;
        pointUpdate(index,val,0,0,n-1);
    }
    public int sumRange(int left, int right) {
        int n = nums.length;
        return sum(0,0,n-1,left,right);
    }
    public void build(int i, int lo, int hi){
        if(lo == hi){
            st[i] = nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(2*i+1,lo,mid);
        build(2*i+2,mid+1,hi);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public void pointUpdate(int index, int val, int i, int lo, int hi){
        if(lo == hi){
            st[i] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(index <= mid) pointUpdate(index,val,2*i+1,lo,mid);
        else pointUpdate(index,val,2*i+2,mid+1,hi);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public int sum(int i, int lo, int hi, int l, int r){
        if(lo > r || l > hi) return 0;
        if(lo >= l && hi <= r) return st[i];
        else{
            int mid = lo + (hi - lo) / 2;
            return sum(2*i+1,lo,mid,l,r) + sum(2*i+2,mid+1,hi,l,r); 
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */