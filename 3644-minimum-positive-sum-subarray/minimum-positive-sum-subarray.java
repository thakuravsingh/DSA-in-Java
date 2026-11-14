class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int curSum = 0;
            for(int j = i; j < n; j++){
                curSum += nums.get(j);
                if(j - i + 1 >= l && j - i + 1 <= r){
                    if(curSum > 0) minSum = Math.min(minSum,curSum);
                }
                else if(j - i + 1 > r) break;
            }
        }
        return minSum != Integer.MAX_VALUE ? minSum : -1; 
    }
}