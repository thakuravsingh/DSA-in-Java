class Solution {
    int[] st;
    public List<Boolean> getResults(int[][] queries) {
        int n = 50001;
        st = new int[4*n];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        List<Boolean> list = new ArrayList<>();
        for(int[] ele : queries){
            if(ele[0] == 1) {
                int x = ele[1];
                Integer next = set.higher(x);
                Integer prev = set.lower(x);
                if(prev != null) update(0,0,n-1,x,x-(int)prev);
                if(next != null) update(0,0,n-1,(int)next,(int)next-x);
                set.add(x);
            }
            else{
                int x = ele[1];
                int sz = ele[2];
                Integer prev = set.lower(x);
                int maxGap = (prev != null) ? Math.max(x-prev,find(0,0,n-1,0,x)) : find(0,0,n-1,0,x);
                if(maxGap >= sz) list.add(true);
                else list.add(false);
            }
        }
        return list;
    }
    public int find(int i, int lo, int hi, int l, int r){
        if(lo > r  || l > hi) return -1;
        if(lo >= l && hi <= r) return st[i];
        int mid = lo + (hi - lo) / 2;
        int left = find(2*i+1,lo,mid,l,r);
        int right = find(2*i+2,mid+1,hi,l,r);
        return Math.max(left,right);
    }
    public void update(int i, int lo, int hi, int idx, int val){
        if(lo == hi){
            st[i] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        if(idx <= mid) update(2*i+1,lo,mid,idx,val);
        else update(2*i+2,mid+1,hi,idx,val);
        st[i] = Math.max(st[2*i+1],st[2*i+2]);
    }
}