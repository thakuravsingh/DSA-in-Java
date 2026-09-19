class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return minCost(days,costs,0);
    }
    public int minCost(int[] days, int[] costs, int i){
        int n = days.length;
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int dayPass = costs[0] + minCost(days,costs,i+1);
        int idx1 = i;
        int valid1 = days[i] + 6;
        int idx2 = i;
        int valid2 = days[i] + 29;
        for(int j = i+1; j < n; j++){
            if(days[j] <= valid1) idx1 = j;
            if(days[j] <= valid2) idx2 = j;
        }
        int weekPass = costs[1] + minCost(days,costs,idx1+1);
        int monthPass = costs[2] + minCost(days,costs,idx2+1);
        return dp[i] = Math.min(dayPass,Math.min(weekPass,monthPass));
    }
}