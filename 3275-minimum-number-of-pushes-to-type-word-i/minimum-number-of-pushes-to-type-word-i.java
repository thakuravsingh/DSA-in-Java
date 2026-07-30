class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int quo = n / 8;
        int rem = n % 8;
        int ans = 0;
        for(int i = 1; i <= quo; i++) ans += (8 * i);
        ans += (quo + 1) * rem;
        return ans;
    }
}