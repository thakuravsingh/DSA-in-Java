class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            int age = ages[i];
            int score = scores[i];
            nums[i][0] = age;
            nums[i][1] = score;
        }
        Arrays.sort(nums,(a,b)->{
            if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = nums[i][1];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++) {
                if(nums[j][1] <= nums[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i][1]);
                }
            }
        }
        int max = 0;
        for(int ele : dp) max = Math.max(max,ele);
        return max;
    }
}