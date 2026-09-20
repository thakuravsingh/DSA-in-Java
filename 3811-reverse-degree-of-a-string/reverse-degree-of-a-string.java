class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char first = 'a';
        for(int i = 26; i >= 1; i--) map.put(first++,i);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = map.get(ch);
            sum += (idx * (i+1));
        }
        return sum;
    }
}