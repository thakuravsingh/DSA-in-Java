class Solution {
    public int maxEnvelopes(int[][] grid) {
        int n = grid.length;
        Arrays.sort(grid, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int ele = grid[i][1];
            int ans = -1;
            if(list.isEmpty() || ele > list.getLast()) list.add(ele);
            else{
                int lo = 0;
                int hi = list.size()-1;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if(list.get(mid) >= ele){
                        ans = mid;
                        hi = mid - 1;
                    }
                    else lo = mid + 1;
                }
            }
            if(ans != -1) list.set(ans,ele);
        }
        return list.size();
    }
}