class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            int len1 = a.length();
            int len2 = b.length();
            return Integer.compare(len1,len2);
        });
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isSubsequence(words[j],words[i])) dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }
        int max = 1;
        for(int ele : dp) max = Math.max(ele,max);
        return max;
    }
    public boolean isSubsequence(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        if(len2 - len1 != 1) return false;
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            else j++;
        }
        return i == len1; 
    }
}