class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while(i < n){
            while(j < n && (!map.containsKey(nums[j]) || map.get(nums[j]) < k)){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                j++;
            }
            maxLength = Math.max(maxLength,j-i);
            map.put(nums[i],map.getOrDefault(nums[i],0)-1);
            i++;
        }
        return maxLength;
    }
}