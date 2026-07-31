class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) freq[ch-'a']++;
        Arrays.sort(freq);
        int ans = 0;
        int count = 0;
        for(int i = 25; i >= 0 && freq[i] > 0; i--){
            count++;
            int a = count / 8;
            if((count % 8) != 0) a++;
            ans += a * freq[i];
        }
        return ans;
    }
}