class Solution {
    public int[][] merge(int[][] occupiedIntervals) {
        int n = occupiedIntervals.length;
        Arrays.sort(occupiedIntervals,(a,b)->
        {if(a[0] == b[0]) return b[1] - a[1];
            return a[0]-b[0];
        });
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        for(int i = 0; i < n;){
            int start = occupiedIntervals[i][0];
            int end = occupiedIntervals[i][1];
            inner = new ArrayList<>();
            int j = i;
            while(j < n && occupiedIntervals[j][0] <= end){
                end = Math.max(end, occupiedIntervals[j][1]);
                j++;
            }
            inner.add(start);
            inner.add(end);
            list.add(inner);
            i = j;
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}