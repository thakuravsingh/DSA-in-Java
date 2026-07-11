class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] ele : edges){
            adj.get(ele[0]).add(ele[1]);
            adj.get(ele[1]).add(ele[0]);
        }
        int[] vis = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(adj,vis,i);
                HashSet<Integer> set = new HashSet<>();
                for(int j = 0; j < n; j++){
                    if(vis[j] == 1){
                        set.add(j);
                        vis[j] = 2;
                    }
                }
                int countedges = 0;
                int m = set.size();
                for(int[] ele : edges) if(set.contains(ele[0]) || set.contains(ele[1])) countedges++;
                if(countedges == (m * (m - 1)) / 2) ans++;
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int i){
        vis[i] = 1;
        for(int ele : adj.get(i)){
            if(vis[ele] == 0) dfs(adj,vis,ele);
        }
    }
}