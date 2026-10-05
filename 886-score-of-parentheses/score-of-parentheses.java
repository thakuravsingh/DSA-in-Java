class Solution {
    public int scoreOfParentheses(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = s.length();
        int score = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                list.add(score);
                score = 0;
            }
            else{
                if(s.charAt(i-1) == '(') score = list.getLast() + 1;
                else score = list.getLast() + (2 * score);
                list.removeLast();
            }
        }
        return score;
    }
}