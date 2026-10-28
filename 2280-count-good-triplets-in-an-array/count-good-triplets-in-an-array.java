class Solution {
    int[] st;
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(nums2[i],i);
        st = new int[4*n];
        long ans = 0;
        int firstUpdate = map.get(nums1[0]);
        update(0,0,n-1,firstUpdate);
        for(int i = 1; i < n - 1; i++){
            int r = map.get(nums1[i]);
            long leftCommonCount = query(0, r - 1, 0, 0, n - 1);
            long leftUnCommonCount = i - leftCommonCount;
            long rightCommonCount = n - 1 - r - leftUnCommonCount;
            ans += leftCommonCount * rightCommonCount;
            update(0,0,n-1,r);
        }
        return ans;
    }
    public int query(int l, int r, int i, int lo, int hi){
        if(l > hi || lo > r) return 0;
        if(lo >= l && hi <= r) return st[i];
        int mid = lo + (hi - lo) / 2;
        int left = query(l,r,2*i+1,lo,mid);
        int right = query(l,r,2*i+2,mid+1,hi);
        return left + right;
    }
    public void update(int i, int lo, int hi, int idx){
        if(lo == hi) {
            st[i] = 1;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(idx <= mid) update(2*i+1,lo,mid,idx);
        else update(2*i+2,mid+1,hi,idx);
        st[i] = st[2*i+1] + st[2*i+2];
    }
}