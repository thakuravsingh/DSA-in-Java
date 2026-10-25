class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int[][] cnt = new int[n][27];
        for(int i = 0; i < n; i++){
            HashSet<Character> s1 = new HashSet<>();
            for(int j = i; j >= 0; j--){
                s1.add(s.charAt(j));
                cnt[i][s1.size()]++;
            }
        }
        int ans = 0;
        for(int j = n - 1; j >= 0; j--){
            HashSet<Character> s2 = new HashSet<>();
            for(int m = j - 1; m >= 0; m--){
                s2.add(s.charAt(m+1));
                ans += cnt[m][s2.size()];
            }
        }
        return ans;
    }
}