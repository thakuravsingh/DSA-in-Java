class Solution {
    int mod = (int)1e9+7;
    int[] count;
    public int numberOfUniqueGoodSubsequences(String s) {
        count = new int[2];
        getDistinctSub(s, 0);
        int ans = count[1];
        if (s.indexOf('0') != -1) ans = (ans + 1) % mod;
        return ans;
    }
    public int getDistinctSub(String s, int i){
        if(i == s.length()) return 1;
        char ch = s.charAt(i);
        int total = getDistinctSub(s,i+1);
        int cur = count[ch-'0']; 
        long ans = (2L * total - cur + mod) % mod;
        count[ch - '0'] = total;
        return (int)ans;
    }
}