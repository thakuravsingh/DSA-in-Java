class Solution {
    int[][] dp;
    int mod = (int)1e9+7;
    public int knightDialer(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            ArrayList<Integer> cur = new ArrayList<>();
            if(i == 0){
                cur.add(4);
                cur.add(6);
            }
            else if(i == 1){
                cur.add(6);
                cur.add(8);
            }
            else if(i == 2){
                cur.add(7);
                cur.add(9);
            }
            else if(i == 3){
                cur.add(4);
                cur.add(8);
            }
            else if(i == 4){
                cur.add(0);
                cur.add(3);
                cur.add(9);
            }
            else if(i == 6){
                cur.add(0);
                cur.add(1);
                cur.add(7);
            }
            else if(i == 7){
                cur.add(2);
                cur.add(6);
            }
            else if(i == 8){
                cur.add(1);
                cur.add(3);
            }
            else if(i == 9){
                cur.add(2);
                cur.add(4);
            }
            list.add(cur);
        }
        dp = new int[n+1][10];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i],-1);
        long ans = 0;
        for(int i = 0; i <= 9; i++){
            ans = (ans +  fxn(list,n-1,i)) % mod;
        }
        return (int)ans;
    }
    public int fxn(ArrayList<ArrayList<Integer>> list, int n, int curPos){
        if(n == 0) return 1;
        if(dp[n][curPos] != -1) return dp[n][curPos];
        long sum = 0;
        for(int ele : list.get(curPos)){
            sum = (sum + fxn(list,n-1,ele)) % mod;
        }
        return dp[n][curPos] = (int)sum;
    }
}