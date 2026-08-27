class Solution {
    public void fxn(String digits, int i, List<String> ans, HashMap<Character,List<Character>> map, StringBuilder str){
        if(i == digits.length()){
            ans.add(str.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(i));
        for(int j = 0; j < list.size(); j++){
            str.append(list.get(j));
            fxn(digits,i+1,ans,map,str);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        HashMap<Character,List<Character>> map = new HashMap<>();
        char alpha = 'a';
        for(char i = '2'; i<= '9'; i++){
            for(int j = 1; j <= 3; j++){
                if(!map.containsKey(i)) map.put(i,new ArrayList<>());
                map.get(i).add(alpha++);
            }
            if(i == '7' || i == '9') map.get(i).add(alpha++);
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        fxn(digits,0,ans,map,sb);
        return ans;
    }
}