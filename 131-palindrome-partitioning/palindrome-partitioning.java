class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int gap = 1; gap < n; gap++){
            for(int i = 0; i + gap < n; i++){
                int j = gap + i;
                if(s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else{
                    if(j - i == 1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        getValidPartitions(s,0,temp,ans);
        return ans;
    }
    public void getValidPartitions(String s, int i, List<String> temp, List<List<String>> ans){
        if(i == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int k = i; k < s.length(); k++){
            if(dp[i][k]){
                temp.add(s.substring(i,k+1));
                getValidPartitions(s,k+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
}