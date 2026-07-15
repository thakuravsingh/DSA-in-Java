class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n * n;
        int sumEven = n * n + n;
        return gcd(sumOdd,sumEven);
    }
    public int gcd(int a, int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(max % min == 0) return min;
        return gcd(max,max%min);
    }
}