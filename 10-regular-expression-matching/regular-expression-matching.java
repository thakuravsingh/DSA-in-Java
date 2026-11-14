class Solution {
    public boolean isMatch(String s, String p) {
        return getAns(s,p);
    }
    public boolean getAns(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        boolean first = false;
        if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) first = true;
        if(p.length() > 1 && p.charAt(1) == '*'){ 
            boolean skip = getAns(s,p.substring(2));
            boolean pick = first && getAns(s.substring(1),p);
            return skip || pick;
        }
        else {
            return first && getAns(s.substring(1),p.substring(1));
        }
    }
}