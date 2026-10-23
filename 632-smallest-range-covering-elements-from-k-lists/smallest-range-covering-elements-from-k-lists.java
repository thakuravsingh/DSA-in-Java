class Solution {
    class Triple implements Comparable<Triple>{
        int ele;
        int x;
        int y;
        Triple(int ele, int x, int y){
            this.ele = ele;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Triple temp){
            return Integer.compare(this.ele,temp.ele);
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        int[] ans = {0, Integer.MAX_VALUE};
        for (int i = 0; i < k; i++) {
            int next = nums.get(i).get(0);
            pq.add(new Triple(next, i, 0));
            max = Math.max(next, max);
        }
        while (true) {
            Triple top = pq.poll();
            int ele = top.ele;
            int x = top.x;
            int y = top.y;
            int diff = max - ele;
            if (diff < ans[1] - ans[0]) {
                ans[0] = ele;
                ans[1] = max;
            }
            if (y + 1 == nums.get(x).size()) break;

            int next = nums.get(x).get(y + 1);
            pq.add(new Triple(next, x, y + 1));
            max = Math.max(next, max);
        }
        return ans;
    }
}