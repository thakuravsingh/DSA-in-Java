class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < n){
            while(j < n && (!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) < 2)){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                j++;
            }
            ans = Math.max(ans,j-i);
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
            i++;
        }
        return ans;
    }
}