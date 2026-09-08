class Solution {
    public int countCommas(int n) {
        int digits = 0;
        int num = n;
        while(num != 0){
            num /= 10;
            digits++;
        }
        if(digits < 4) return 0;
        else return n - 999;
    }
}