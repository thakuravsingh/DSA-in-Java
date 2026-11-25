class Solution {
    public int findCenter(int[][] edges) {
        int e = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= e + 1; i++) adj.add(new ArrayList<>());
        int maxDeg = -1;
        int maxNode = -1;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            if(adj.get(u).size() > maxDeg){
                maxDeg = adj.get(u).size();
                maxNode = u;
            }
            if(adj.get(v).size() > maxDeg){
                maxDeg = adj.get(v).size();
                maxNode = v;
            }
        }
        return maxNode;
    }
}