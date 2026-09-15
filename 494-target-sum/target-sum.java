class Solution {
    HashMap<String,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        map = new HashMap<>();
        return findWays(nums,target,0,0);
    }
    public int findWays(int[] nums, int tgt, int i, int cur){
        int n = nums.length;
        if(i == n){
            if(cur == tgt) return 1;
            else return 0;
        }
        String s = i + "," + cur;
        if(map.containsKey(s)) return map.get(s);
        int minus = findWays(nums,tgt,i+1,cur-nums[i]);
        int add = findWays(nums,tgt,i+1,cur+nums[i]);
        int tot = minus+add;
        map.put(s,tot);
        return tot;
    }
}