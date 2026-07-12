class Solution {
    class Pair implements Comparable<Pair>{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
        public int compareTo(Pair temp){
            return Integer.compare(this.val,temp.val);
        } 
    }
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) pq.add(new Pair(i,arr[i]));
        int[] ans = new int[n];
        int rank = 1;
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            ans[top.idx] = rank;
            if(!pq.isEmpty() && top.val != pq.element().val) rank++;
        }
        return ans;
    }
}