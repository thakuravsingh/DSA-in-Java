class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int mask = 0;
        map.put(0,-1);
        for(int i = 0; i < n; i++){
            char alphabet = s.charAt(i);
            if(alphabet == 'a') mask = mask ^ 1;
            else if(alphabet == 'e') mask = mask ^ 2;
            else if(alphabet == 'i') mask = mask ^ 4;
            else if(alphabet == 'o') mask = mask ^ 8;
            else if(alphabet == 'u') mask = mask ^ 16;
            if(map.containsKey(mask)) ans = Math.max(ans,i-map.get(mask));
            else map.put(mask,i);
        }
        return ans;
    }
}