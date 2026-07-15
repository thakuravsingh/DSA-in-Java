class Solution {
    public int maxDistance(String moves) {
        int n = moves.length();
        int ans = 0;
        ArrayList<Character> list = new ArrayList<>();
        int dash = 0;
        for(int i = 0; i < n; i++){
            char ch = moves.charAt(i);
            if(ch != '_') list.add(ch);
            else dash++;
        }
        int x = 0;
        int y = 0;
        for(char ch : list){
            if(ch == 'U') y--;
            else if(ch == 'L') x--;
            else if(ch == 'R') x++;
            else y++;
        }
        ans = Math.abs(x) + Math.abs(y);
        ans += dash;
        return ans;
    }
}