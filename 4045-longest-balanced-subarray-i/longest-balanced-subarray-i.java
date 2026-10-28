class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxL = 0;
        int[] cumSum = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int val = (nums[i] % 2 == 1) ? 1 : -1;
            int prev = -1;
            if(map.containsKey(nums[i])) prev = map.get(nums[i]);
            if(prev != -1){
                for(int j = 0; j <= prev; j++) cumSum[j] -= val;
            }
            for(int j = 0; j <= i; j++) cumSum[j] += val;
            for(int j = 0; j <= i; j++){
                if(cumSum[j] == 0){
                    maxL = Math.max(maxL,i-j+1);
                    break;
                }
            }
            map.put(nums[i],i);
        }
        return maxL;
    }
}