class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i && i >= 2; j++){
                int up = list.get(i-1).get(j);
                int dia = list.get(i-1).get(j-1);
                temp.add(up+dia);
            }
            if(i != 0) temp.add(1);
            list.add(temp);
        }
        return list;
    }
}