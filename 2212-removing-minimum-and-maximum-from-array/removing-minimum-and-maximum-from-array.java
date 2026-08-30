class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for(int i = 0; i < n; i++){
            if(min > nums[i]){
                min = nums[i];
                minIdx = i;
            }
            if(max < nums[i]){
                max = nums[i];
                maxIdx = i;
            }
        }
        int[] possible = new int[4];
        possible[0] = (minIdx + 1 + (n - maxIdx));
        possible[1] = (maxIdx + 1 + (n - minIdx));
        possible[2] = Math.max(minIdx+1,maxIdx+1);
        possible[3] = Math.max((n-minIdx),(n-maxIdx));
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) if(possible[i] > 0) ans = Math.min(ans,possible[i]);
        return ans;
    }
}