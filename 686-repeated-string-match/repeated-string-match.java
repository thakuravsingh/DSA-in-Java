class Solution {
    public int repeatedStringMatch(String a, String b) {
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
        int count = 0;
        StringBuilder repeat = new StringBuilder(a);
        while(true){
            int n = repeat.length();
            count++;
            i = 0;
            int j = 0;
            boolean flag = false;
            while(i < n){
                if(repeat.charAt(i) == b.charAt(j)){
                    i++;
                    j++;
                }
                if(j == m){
                    flag = true;
                    break;
                }
                else if(i < n && repeat.charAt(i) != b.charAt(j)){
                    if(j != 0) j = lps[j-1];
                    else i++;
                }
            }
            if(flag) break;
            if(count >= (m + a.length() - 1) / a.length() + 1) return -1;
            repeat.append(a);
        }
        return count;
    }
}