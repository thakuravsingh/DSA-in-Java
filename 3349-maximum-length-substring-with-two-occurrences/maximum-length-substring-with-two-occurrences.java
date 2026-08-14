class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < n){
            while(j < n && (freq[s.charAt(j)-'a'] < 2)){
                freq[s.charAt(j)-'a']++;
                j++;
            }
            ans = Math.max(ans,j-i);
            freq[s.charAt(i)-'a']--;
            i++;
        }
        return ans;
    }
}