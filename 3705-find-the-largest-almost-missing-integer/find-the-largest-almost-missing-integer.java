class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(k == n){
            int max = -1;
            for(int i = 0; i < n; i++) max = Math.max(max,nums[i]);
            return max;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        if(k == 1){
            int max = -1;
            for(int i = 0; i < n; i++) if(map.get(nums[i]) == 1)  max = Math.max(max,nums[i]);
            if(max != -1) return max;
        }
        if(map.get(nums[n-1]) > 1 && map.get(nums[0]) > 1) return -1;
        if(map.get(nums[n-1]) > 1) return nums[0];
        if(map.get(nums[0]) > 1) return nums[n-1];
        return Math.max(nums[0],nums[n-1]);
    }
}