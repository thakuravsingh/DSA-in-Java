class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(List<String> edge : paths){
            String a = edge.get(0);
            String b = edge.get(1);
            if(!map.containsKey(a)) map.put(a,count++);
            if(!map.containsKey(b)) map.put(b,count++);
        }
        int n = map.size();
        int[] out = new int[n];
        for(List<String> edge : paths){
            String a = edge.get(0);
            String b = edge.get(1);
            out[map.get(a)]++;
        }
        for(int i = 0; i < n; i++){
            if(out[i] == 0){
                for(String key : map.keySet()){
                    int idx = map.get(key);
                    if(i == idx) return key;
                }
            }
        }
        return "";
    }
}