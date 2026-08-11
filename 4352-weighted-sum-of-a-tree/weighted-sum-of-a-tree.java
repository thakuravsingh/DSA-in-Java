class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++) adj.get(parent[i]).add(i);
        int[] depth = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int curdepth = 0;
        while(!q.isEmpty()){
            curdepth++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int front = q.remove();
                depth[front] = curdepth;
                for(int ele : adj.get(front)) q.add(ele);
            }
        }
        int h = curdepth;
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += (long)nums[i] * (h - depth[i] + 1);
        }
        return ans;
    }
}