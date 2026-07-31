class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        int unique = 0;
        for(char ch : word.toCharArray()){
            if(freq[ch-'a'] == 0) unique++;
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int quo = unique / 8;
        int rem = unique % 8;
        int ans = 0;
        for(int i = 1; i <= quo; i++) ans += (8 * i);
        ans += (quo + 1) * rem;
        int count = 0;
        for(int i = 25; i >= 0 && freq[i] > 0; i--){
            count++;
            int a = count / 8;
            int b = count % 8;
            if(b != 0) a++;
            ans += a * (freq[i] - 1);
        }
        return ans;
    }
}