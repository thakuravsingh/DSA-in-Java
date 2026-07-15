class Solution {
    public int maxDistance(String moves) {
        int n = moves.length();
        int ans = 0;
        int dash = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            char ch = moves.charAt(i);
            if(ch == 'U') y--;
            else if(ch == 'L') x--;
            else if(ch == 'R') x++;
            else if(ch == 'D') y++;
            else dash++;
        }
        ans = Math.abs(x) + Math.abs(y);
        ans += dash;
        return ans;
    }
}