class Solution {
    public int clumsy(int n) {
        if(n == 1 || n == 2) return n;
        if(n == 3) return 2 * n;
        if(n == 4) return 2 * n - 1;
        if(n % 4 == 1 || n % 4 == 2) return n + 2;
        if(n % 4 == 3) return n - 1;
        else return n + 1; 
    }
}