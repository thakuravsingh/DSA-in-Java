class Solution {
    int mod = (int)1e9+7;
    int[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int maxProfit = 0;
        for(int ele : profit) maxProfit += ele;
        dp = new int[len+1][n+1][maxProfit+1];
        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= n; j++) Arrays.fill(dp[i][j],-1);
        }
        int ans = totalNum(n,minProfit,group,profit,0,0,0);
        if(minProfit == 0) ans++;
        return ans;
    }
    public int totalNum(int n, int minProfit, int[] group, int[] profit, int i, int curMember, int curProfit){
        int len = group.length;
        if(i >= len) return 0;
        if(dp[i][curMember][curProfit] != -1) return dp[i][curMember][curProfit];
        long skip = totalNum(n,minProfit,group,profit,i+1,curMember,curProfit);
        long pick = (n >= curMember+group[i]) ? (minProfit <= curProfit+profit[i] ?
                1 + totalNum(n,minProfit,group,profit,i+1,curMember+group[i],curProfit+profit[i]) :
                totalNum(n,minProfit,group,profit,i+1,curMember+group[i],curProfit+profit[i])) : 0;
        return dp[i][curMember][curProfit] = (int)(skip+pick) % mod;
    }
}