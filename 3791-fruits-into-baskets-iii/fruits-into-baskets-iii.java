class Solution {
    int[] st;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        st = new int[4*n];
        build(baskets,0,0,n-1);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int curIdx = query(fruits[i],0,0,n-1);
            if(curIdx == -1){
                ans++;
                continue;
            }
            update(0,0,n-1,curIdx);
        }
        return ans;
    }
    public void build(int[] arr, int i, int lo, int hi){
        if(lo == hi){
            st[i] = arr[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(arr,2*i+1,lo,mid);
        build(arr,2*i+2,mid+1,hi);
        st[i] = Math.max(st[2*i+1],st[2*i+2]);
    }
    public int query(int fruit,int i, int lo, int hi){
        if(lo == hi){
            if(st[i] >= fruit) return lo;
            else return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if(st[2*i+1] >= fruit) return query(fruit,2*i+1,lo,mid);
        else if(st[2*i+2] >= fruit) return query(fruit,2*i+2,mid+1,hi);
        else return -1;
    }
    public void update(int i, int lo, int hi, int idx){
        if(lo == hi){
            st[i] = -1;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(idx <= mid) update(2*i+1,lo,mid,idx);
        else update(2*i+2,mid+1,hi,idx);
        st[i] = Math.max(st[2*i+1],st[2*i+2]);
    }
}