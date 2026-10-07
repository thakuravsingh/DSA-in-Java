class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }
        int max = 0;
        int it = -1;
        for(int i = 0; i < n; i++){
            if(max < dp[i]){
                max = dp[i];
                it = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(it != -1){
            list.add(nums[it]);
            it = parent[it];
        }
        Collections.sort(list);
        return list;
    }
}