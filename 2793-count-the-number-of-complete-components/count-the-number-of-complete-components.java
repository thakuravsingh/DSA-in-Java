class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] deg = new int[n];
        for(int[] ele : edges){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
            deg[ele[0]]++;
            deg[ele[1]]++;
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        int[] nodes = new int[1];
        int[] degSum = new int[1];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                nodes[0] = 0;
                degSum[0] = 0;
                dfs(adj,vis,i,deg,nodes,degSum);
                if((degSum[0] / 2) == (nodes[0] * (nodes[0] - 1) / 2)) ans++;
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i, int[] deg, int[] nodes, int[] degSum){
        for(int ele : adj.get(i)){
            if(!vis[ele]){
                vis[ele] = true;
                nodes[0]++;
                degSum[0] += deg[ele];
                dfs(adj,vis,ele,deg,nodes,degSum);
            }
        }
    }
}