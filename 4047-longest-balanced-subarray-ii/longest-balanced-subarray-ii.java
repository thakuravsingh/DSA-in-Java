class Solution {
    int[] minSt;
    int[] maxSt;
    int[] lazy;
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        minSt = new int[4*n];
        maxSt = new int[4*n];
        lazy = new int[4*n];
        int maxL = 0;
        int[] cumSum = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int val = (nums[i] % 2 == 1) ? 1 : -1;
            int prev = -1;
            if(map.containsKey(nums[i])) prev = map.get(nums[i]);
            if(prev != -1) update(0,prev,-val,0,0,n-1);
            update(0,i,val,0,0,n-1);
            int j = getLeftMostZero(0,0,n-1);
            if(j != -1) maxL = Math.max(i-j+1,maxL);
            map.put(nums[i],i);
        }
        return maxL;
    }
    public int getLeftMostZero(int i, int lo, int hi){
        if(lazy[i] != 0){
            minSt[i] += lazy[i];
            maxSt[i] += lazy[i];
            if(lo != hi){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        if(minSt[i] > 0 || maxSt[i] < 0) return -1;
        if(lo == hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int left = getLeftMostZero(2*i+1,lo,mid);
        if(left != -1) return left;
        return getLeftMostZero(2*i+2,mid+1,hi);
    }
    public void update(int l, int r, int val, int i, int lo, int hi){
        if(lazy[i] != 0){
            minSt[i] += lazy[i];
            maxSt[i] += lazy[i];
            if(lo != hi){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }
        if(l > hi || lo > r) return;
        if(lo >= l &&  hi <= r){
            minSt[i] += val;
            maxSt[i] += val;
            if(lo != hi){
                lazy[2*i+1] += val;
                lazy[2*i+2] += val;
            }
            return;
        }
        int mid = lo + (hi - lo) / 2;
        update(l,r,val,2*i+1,lo,mid);
        update(l,r,val,2*i+2,mid+1,hi);
        minSt[i] = Math.min(minSt[2*i+1],minSt[2*i+2]);
        maxSt[i] = Math.max(maxSt[2*i+1],maxSt[2*i+2]);
    }
}