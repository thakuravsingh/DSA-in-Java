class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n = s.length();
        int[] ans = new int[n];
        int depth = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                depth++;
                if(depth % 2 == 0) ans[i] = 0;
                else ans[i] = 1;
            }
            else{
                if(depth % 2 == 0) ans[i] = 0;
                else ans[i] = 1;
                depth--;
            }
        }
        return ans;
    }
}