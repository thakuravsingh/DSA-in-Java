class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0]-b[0];
        });
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(intervals[0][0],intervals[0][1]));
        for(int i = 1; i < n; i++){
            Pair last = arr.get(arr.size()-1);
            int lst = last.b;
            if(intervals[i][1] > lst) arr.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        return arr.size();
    }
}