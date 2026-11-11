class Solution {
    public long countValidSubstrings(String s) {
        long ans = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            if(r  > 1 && s.charAt(r-2) == 'a' && s.charAt(r-1) == 'b' && s.charAt(r) == 'c') l = r - 1;
            ans += (r - l + 1);
        }
        return ans;
    }
}