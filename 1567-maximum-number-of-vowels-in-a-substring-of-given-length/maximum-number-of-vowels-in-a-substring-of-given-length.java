class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = k - 1;
        int ans = 0;
        int cur = 0;
        for(int idx = i; idx <= j; idx++){
            char ch = s.charAt(idx);
            if(ch == 'a' || ch == 'e' || ch =='i' || ch=='o' || ch == 'u') cur++;
        }
        ans = cur;
        i++;
        for(j = j + 1; j < n; j++){
            char ch = s.charAt(i-1);
            char ch2 = s.charAt(j);
            if(ch == 'a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u') cur--;
            if(ch2 == 'a' || ch2 == 'e' || ch2 =='i' || ch2 =='o' || ch2 == 'u') cur++;
            ans = Math.max(cur,ans);
            i++;
        }
        return ans;
    }
}