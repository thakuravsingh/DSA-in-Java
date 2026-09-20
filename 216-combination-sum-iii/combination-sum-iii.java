class Solution {
    int[] nums;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        nums = new int[9];
        for(int i = 0; i < 9; i++) nums[i] = i + 1;
        generate(new ArrayList<>(),ans,k,n,0);
        return ans;
    }
    public void generate(List<Integer> list, List<List<Integer>> ans, int k, int n, int i){
        if(k == 0){
            if(n == 0){
                List<Integer> temp = new ArrayList<>(list);
                ans.add(temp);
            }
            return;
        }
        if(i >= 9) return;
        generate(list,ans,k,n,i+1);
        if(nums[i] <= n){
            list.add(nums[i]);
            generate(list,ans,k-1,n-nums[i],i+1);
            list.removeLast();
        }
    }
}