class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        ans = new ArrayList<>();
        generate(nums,n-1,new ArrayList<>());
        return ans;
    }
    public void generate(int[] nums, int j, List<Integer> list){
        if(j < 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int idx = j; idx >= 0; idx--){
            swap(nums,idx,j);
            list.add(nums[j]);
            generate(nums,j-1,list);
            list.remove(list.size()-1);
            swap(nums,idx,j);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}