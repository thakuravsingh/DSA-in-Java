class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        int[] idx = new int[n];
        Arrays.fill(idx,-1);
        int b = -1;
        long ans = 0;
        int l = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a') idx[i] = i;
            else if(i > 0) idx[i] = idx[i-1];
            if(s.charAt(i) == 'b') b = i;
            else if(s.charAt(i) == 'c'){
                if(b != -1 && idx[b] != -1) l = idx[b] + 1;
            } 
            ans += (i - l + 1);
        }
        return ans;
    }
}