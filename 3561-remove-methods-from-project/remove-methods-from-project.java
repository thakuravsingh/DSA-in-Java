class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] ele : invocations){
            int u = ele[0];
            int v = ele[1];
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        vis[k] = true;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}