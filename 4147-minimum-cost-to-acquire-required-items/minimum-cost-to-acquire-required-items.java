class Solution {
    public long minimumCost(int cost_1, int cost_2, int cost_Both, int need_1, int need_2) {
        long ans = 0;
        long cost1 = cost_1;
        long cost2 = cost_2;
        long costBoth = cost_Both;
        long need1 = need_1;
        long need2 = need_2;
        if(costBoth <= cost1 && costBoth <= cost2) ans = costBoth * Math.max(need1,need2);
        else if(costBoth <= cost1 && costBoth > cost2){
            ans = costBoth * need1;
            if(need1 < need2) ans += cost2 * (need2 - need1);
        }
        else if(costBoth > cost1 && costBoth <= cost2){
            ans = costBoth * need2;
            if(need1 > need2) ans += cost1 * (need1 - need2);
        }
        else if(costBoth <= (cost1 + cost2)){
            if(need1 >= need2){
                ans = costBoth * need2;
                ans += cost1 * (need1-need2);
            }
            else{
                ans = costBoth * need1;
                ans += cost2 * (need2-need1);
            }
        }
        else{
            ans = cost1 * need1;
            ans += cost2 * need2;
        }
        return ans;
    }
}