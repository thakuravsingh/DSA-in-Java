class Solution {
    int mod = (int)1e9+7;
    public int fxn(String s, int idx, long[] freq){
        int n = s.length();
        if(idx == n - 1){
            freq[s.charAt(idx)-'a']++;
            return 2;
        }
        long nextAns = fxn(s,idx+1,freq);
        long ans = (2*nextAns) % mod;
        int i = s.charAt(idx)-'a';
        int fr = (int)freq[i];
        freq[i] = nextAns; 
        ans = (ans - fr + mod) % mod;
        return (int)ans;
    }
    public int distinctSubseqII(String s) {
        long[] freq = new long[26];
        int ans = fxn(s, 0, freq) - 1;
        return (ans + mod) % mod;
    }
}