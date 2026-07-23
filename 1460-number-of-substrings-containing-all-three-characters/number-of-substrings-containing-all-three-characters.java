class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int[] freq = new int[3];
        int ans = 0;
        while(j < n){
            freq[s.charAt(j)-'a']++;
            while(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1){
                ans += n - j;
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}