class Solution {
    public boolean canAliceWin(int n) {
        int turn = 0;  // 0 means alice and 1 means bob
        int num = n;
        int cur = 10;
        while(num >= cur){
            if(turn == 0) turn = 1;
            else turn = 0;
            num -= cur;
            cur--;
        }
        return (turn == 0) ? false : true;
    }
}