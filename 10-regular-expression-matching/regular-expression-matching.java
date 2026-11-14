class Solution {
    public boolean isMatch(String s, String p) {
        return getAns(s,p,0,0);
    }
    public boolean getAns(String s, String p, int i, int j){
        int m = s.length();
        int n = p.length();
        if(j == n) return i == m;
        boolean first = false;
        if(i < m && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) first = true;
        if(j < n - 1 && p.charAt(j+1) == '*'){
            boolean skip = getAns(s,p,i,j+2);
            boolean pick = first && getAns(s,p,i+1,j);
            return skip || pick;
        }
        else {
            return first && getAns(s,p,i+1,j+1);
        }
    }
}