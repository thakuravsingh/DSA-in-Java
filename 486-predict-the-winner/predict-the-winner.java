class Solution {
    public int helper(int[] nums, int i, int j){
        if(i > j) return 0;
        int begin = nums[i] + Math.min(helper(nums,i+2,j),helper(nums,i+1,j-1));
        int end = nums[j] + Math.min(helper(nums,i,j-2),helper(nums,i+1,j-1));
        return Math.max(begin,end);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        int player1 = helper(nums,0,n-1);
        int player2 = sum - player1;
        return (player1 >= player2);
    }
}