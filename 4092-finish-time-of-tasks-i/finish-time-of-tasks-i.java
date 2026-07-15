class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] ele : edges){
            int u = ele[0];
            int v = ele[1];
            adj.get(u).add(v);
        }
        long[] finish = new long[n];
        dfs(adj,0,baseTime,finish);
        return finish[0];
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] baseTime, long[] finish){
        if(adj.get(i).isEmpty()){
            finish[i]=baseTime[i];
            return;
        }
        long latest = Long.MIN_VALUE;
        long earliest = Long.MAX_VALUE;
        for(int ele : adj.get(i)){
            dfs(adj,ele,baseTime,finish);
            latest = Math.max(latest,finish[ele]);
            earliest = Math.min(earliest,finish[ele]);
        }
        finish[i] = latest + (latest - earliest) + baseTime[i];
    }
}