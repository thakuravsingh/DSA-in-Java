class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0]-b[0];
        });
        int last = intervals[0][1];
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(intervals[i][1] > last){
                last = intervals[i][1];
                ans++;
            }
        }
        return ans;
    }
}