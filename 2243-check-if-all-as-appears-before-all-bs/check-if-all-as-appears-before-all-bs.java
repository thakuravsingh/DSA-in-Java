class Solution {
    public boolean checkString(String s) {
        Boolean flag = null;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                if(flag == null) flag = true;
                else if(flag == false) return false;
            }
            else{
               flag = false;
            }
        }
        return true;
    }
}