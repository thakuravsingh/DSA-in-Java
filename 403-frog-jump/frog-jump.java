class Solution {
    Boolean[][] dp;
    HashMap<Integer,Integer> map;
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0] != 1) return false;
        int n = stones.length;
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(stones[i],i);
        dp = new Boolean[n+1][2001];
        return helper(1,1,stones);
    }
    public boolean helper(int i, int j, int[] stones){
        int n = stones.length;
        if(i == n - 1) return true;
        if(dp[i][j] != null) return dp[i][j];
        boolean a = false,b = false,c = false;
        if(j != 1){
            if(map.containsKey(stones[i]+j-1)) a = helper(map.get(stones[i]+j-1),j-1,stones);
        }
        if(map.containsKey(stones[i]+j)) b = helper(map.get(stones[i]+j),j,stones);
        if(map.containsKey(stones[i]+j+1)) c = helper(map.get(stones[i]+j+1),j+1,stones);
        return dp[i][j] = a || b || c;
    }
}