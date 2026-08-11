class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int m = prices.length;
        int n  = discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double min_amt = 0;
        int j = n - 1;
        int i = m - 1;
        while(i >= 0){
            double fin = (prices[i] * (100 - discounts[j])) / 100.0;
            min_amt += fin;
            i--;
            j--;
            if(j < 0) break;
        }
        while(i >= 0){
            min_amt += prices[i];
            i--;
        }
        return min_amt;
    }
}