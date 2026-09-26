class Solution {
    public String evaluate(String s, List<List<String>> list) {
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            String key = list.get(i).getFirst();
            String val = list.get(i).getLast();
            map.put(key,val);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();){
            char ch = s.charAt(i);
            StringBuilder temp = new StringBuilder();
            if(ch == '('){
                i++;
                while(s.charAt(i) != ')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                i++;
                sb.append(map.containsKey(temp.toString()) ? map.get(temp.toString()) : '?');
            }
            else{
                sb.append(ch);
                i++;
            }
        }
        return sb.toString();
    }
}