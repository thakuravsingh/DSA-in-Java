class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] ele : edges){
            int u = ele[0];
            int v = ele[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        long[] finish = new long[n];
        dfs(adj,vis,0,baseTime,finish);
        return finish[0];
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i, int[] baseTime, long[] finish){
        vis[i] = true;
        boolean isLeaf = true;
        long latest = Long.MIN_VALUE;
        long earliest = Long.MAX_VALUE;
        for(int ele : adj.get(i)){
            if(!vis[ele]){
                isLeaf = false;
                dfs(adj,vis,ele,baseTime,finish);
                latest = Math.max(latest,finish[ele]);
                earliest = Math.min(earliest,finish[ele]);
            }
        }
        if(isLeaf) finish[i] = baseTime[i];
        else finish[i] = (latest - earliest) + baseTime[i] + latest;
        
    }
}