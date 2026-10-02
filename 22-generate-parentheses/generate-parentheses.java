class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,0,0,ans,"");
        return ans;
    }
    public void generate(int n, int open, int close, List<String> ans, String str){
        if(open > n ||  close > open) return;
        if(open + close == 2 * n){
            if(open == close) ans.add(str);
            return;
        }
        generate(n,open+1,close,ans,str+"(");
        generate(n,open,close+1,ans,str+")");
    }
}