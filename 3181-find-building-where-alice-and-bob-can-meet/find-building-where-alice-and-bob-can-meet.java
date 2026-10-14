class Solution {
    int[] st;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        st = new int[4*n];
        build(heights,0,0,n-1);
        for(int i = 0; i < q; i++){
            int lo = Math.max(queries[i][0],queries[i][1]) + 1;
            int hi = n - 1;
            int alice = Math.min(queries[i][0],queries[i][1]);
            int bob = Math.max(queries[i][0],queries[i][1]);
            if(alice > bob) ans[i] = -1;
            else if(alice == bob) ans[i] = alice;
            else if(heights[bob] > heights[alice]) ans[i] = bob;
            else if(lo > hi) ans[i] = -1;
            else{
                int possible = -1;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    int idx = getRMIQ(heights,lo,mid,0,0,n-1);
                    if(heights[idx] > heights[alice] && heights[idx] > heights[bob]){
                        possible = mid;
                        hi = mid - 1;
                    }
                    else lo = mid + 1;
                }
                ans[i] = possible;
            }
        }
        return ans;
    }
    public void build(int[] arr, int i, int lo, int hi){
        if(lo == hi){
            st[i] = lo;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        build(arr, 2*i+1, lo, mid);
        build(arr, 2*i+2, mid+1, hi);
        int left = st[2*i+1];
        int right = st[2*i+2];
        if(arr[left] >= arr[right]) st[i] = left;
        else st[i] = right;
    }
    public int getRMIQ(int[] arr, int l, int r, int i, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        if(l > hi || lo > r) return -1;
        if(lo >= l && hi <= r) return st[i];
        int left = getRMIQ(arr,l,r,2*i+1,lo,mid);
        int right = getRMIQ(arr,l,r,2*i+2,mid+1,hi);
        if(left == -1) return right;
        if(right == -1) return left;
        if(arr[left] >= arr[right]) return left;
        else return right;
    }
}