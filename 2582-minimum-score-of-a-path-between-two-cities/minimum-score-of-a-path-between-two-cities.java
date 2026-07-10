class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int bfs(ArrayList<ArrayList<Pair>> adj, boolean[] vis, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int front = q.remove();
            for(Pair ele : adj.get(front)){
                min = Math.min(ele.wt,min);
                if(!vis[ele.node]){
                    vis[ele.node] = true;
                    q.add(ele.node);
                }
            }
        }
        return min;
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        boolean[] vis = new boolean[n+1];
        return bfs(adj,vis,1);
    }
}