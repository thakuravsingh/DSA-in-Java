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
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,-1));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair front = q.remove();
            vis[front.node] = true;
            for(Pair ele : adj.get(front.node)){
                min = Math.min(ele.wt,min);
                if(!vis[ele.node]) q.add(new Pair(ele.node,ele.wt));
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