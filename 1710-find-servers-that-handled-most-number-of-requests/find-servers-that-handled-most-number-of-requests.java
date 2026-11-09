class Solution {
    class Pair{
        int id;
        int finTime;
        Pair(int id, int finTime){
            this.id = id;
            this.finTime = finTime;
        }
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        PriorityQueue<Pair> busy = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.finTime,b.finTime);
        });
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; i++) available.add(i);
        int[] requests = new int[k];
        int max = 0;
        for(int i = 0; i < n; i++){
            int curReqId = i % k;
            int fin = arrival[i] + load[i];
            while(!busy.isEmpty() && busy.peek().finTime <= arrival[i]){
                available.add(busy.peek().id);
                busy.remove();
            }
            int target = -1;
            if(!available.isEmpty()) {
                Integer t = available.ceiling(curReqId);
                if(t == null) t = available.first();
                target = t;
            }
            if(target != -1){
                requests[target]++;
                max = Math.max(max,requests[target]);
                busy.add(new Pair(target,fin));
                available.remove(target);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) if(requests[i] == max) list.add(i);
        return list;
    }
}