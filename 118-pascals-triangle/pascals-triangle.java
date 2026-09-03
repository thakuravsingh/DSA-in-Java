class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) ans.add(new ArrayList<>());
        for(int i = 0; i < numRows; i++) ans.get(i).add(1);
        for(int i = 1; i < numRows; i++){
            for(int j = 1; j < i; j++){
                int a = ans.get(i-1).get(j);
                int b = ans.get(i-1).get(j-1);
                ans.get(i).add(a+b);
            }
            ans.get(i).add(1);
        }
        return ans;
    }
}