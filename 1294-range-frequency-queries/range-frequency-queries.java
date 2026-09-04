class RangeFreqQuery {
    int n;
    List<HashMap<Integer,Integer>> st;
    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        st = new ArrayList<>();
        for(int i = 0; i < (4 * n); i++) st.add(new HashMap<>());
        build(0,n-1,0,arr);
    }
    
    public int query(int left, int right, int value) {
        return freqQuery(left,right,value,0,n-1,0);
    }
    public void build(int lo ,int hi, int idx, int[] arr){
        if(lo == hi){
            st.get(idx).put(arr[lo],1);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(lo,mid,2*idx+1,arr);
        build(mid+1,hi,2*idx+2,arr);
        HashMap<Integer,Integer> parent = st.get(idx);
        HashMap<Integer,Integer> left = st.get(2 * idx + 1);
        HashMap<Integer,Integer> right = st.get(2 * idx + 2);
        for(Map.Entry<Integer, Integer> entry : left.entrySet()) parent.put(entry.getKey(),parent.getOrDefault(entry.getKey(), 0) + entry.getValue());
        for(Map.Entry<Integer, Integer> entry : right.entrySet()) parent.put(entry.getKey(),parent.getOrDefault(entry.getKey(), 0) + entry.getValue());
    }
    public int freqQuery(int l, int r, int val, int lo, int hi, int idx){
        if(r < lo || hi < l) return 0;
        if(l <= lo && r >= hi) return st.get(idx).getOrDefault(val, 0);
        int mid = lo + (hi - lo) / 2;
        int left = freqQuery(l,r,val,lo,mid,2*idx+1);
        int right = freqQuery(l,r,val,mid+1,hi,2*idx+2);
        return left + right;
    }
}