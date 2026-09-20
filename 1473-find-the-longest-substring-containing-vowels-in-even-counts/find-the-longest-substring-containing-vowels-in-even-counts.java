class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = s.length();
        int[] ch = new int[5];
        map.put("00000",-1);
        int ans = 0;
        for(int i = 0; i < n; i++){
            char alphabet = s.charAt(i);
            if(alphabet == 'a') ch[0] = (ch[0] + 1) % 2;
            else if(alphabet == 'e') ch[1] = (ch[1] + 1) % 2;
            else if(alphabet == 'i') ch[2] = (ch[2] + 1) % 2;
            else if(alphabet == 'o') ch[3] = (ch[3] + 1) % 2;
            else if(alphabet == 'u') ch[4] = (ch[4] + 1) % 2;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 5; j++){
                sb.append(ch[j]);
            }
            if(map.containsKey(sb.toString())) ans = Math.max(ans,i-map.get(sb.toString()));
            else map.put(sb.toString(),i); 
        }
        return ans;
    }
}