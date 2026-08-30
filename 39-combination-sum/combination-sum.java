class Solution {
    public void fxn(int[] nums, int idx, int target, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || idx == nums.length) return;
        for(int i = idx; i < nums.length; i++){
            target -= nums[i];
            list.add(nums[i]);
            fxn(nums,i,target,list,ans);
            target += nums[i];
            list.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        fxn(nums,0,target,list,ans);
        return ans;
    }
}