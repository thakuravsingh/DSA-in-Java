class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int ele = envelopes[i][1];
            if(arr.isEmpty()) arr.add(ele);
            else if(ele > arr.get(arr.size()-1)) arr.add(ele);
            else{
                int lo = 0;
                int hi = arr.size() - 1;
                int idx = 0;
                while(lo <= hi){
                    int mid = lo + (hi - lo) / 2;
                    if(arr.get(mid) >= ele){
                        idx = mid;
                        hi = mid - 1; 
                    }
                    else lo = mid + 1;
                }
                arr.set(idx,ele);
            }
        }
        return arr.size();
    }
}