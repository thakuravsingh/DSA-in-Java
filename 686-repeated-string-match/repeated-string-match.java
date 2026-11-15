class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] freq = new int[26];
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            freq[ch-'a']++;
        }
        for(int i = 0; i < m; i++){
            char ch = b.charAt(i);
            if(freq[ch-'a'] == 0) return -1;
        }
        int[] lps = new int[m];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i < m){
            if(b.charAt(i) == b.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps[len-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int limit = (m + n - 1) / n + 1;
        int total = limit * n;
        int j = 0;
        for(i = 0; i < total; i++) {
            char ch = a.charAt(i % n);
            while(j > 0 && ch != b.charAt(j)) j = lps[j - 1];
            if(ch == b.charAt(j)) j++;
            if(j == m) return (i + 1 + n - 1) / n;
        }
        return -1;
    }
}