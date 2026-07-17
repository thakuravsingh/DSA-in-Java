class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
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
            int j = i+1;
            while(j < n && occupiedIntervals[j][0] <= end + 1){
                end = Math.max(end, occupiedIntervals[j][1]);
                j++;
            }
            inner.add(start);
            inner.add(end);
            list.add(inner);
            i = j;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> interval : list) {
            int start = interval.get(0);
            int end = interval.get(1);
            if (end < freeStart || start > freeEnd) ans.add(Arrays.asList(start, end));
            else if (start >= freeStart && end <= freeEnd) continue;
            else if (start < freeStart && end <= freeEnd) ans.add(Arrays.asList(start, freeStart - 1));
            else if (start >= freeStart && end > freeEnd) ans.add(Arrays.asList(freeEnd + 1, end));
            else {
                ans.add(Arrays.asList(start, freeStart - 1));
                ans.add(Arrays.asList(freeEnd + 1, end));
            }
        }

        return ans;
    }
}