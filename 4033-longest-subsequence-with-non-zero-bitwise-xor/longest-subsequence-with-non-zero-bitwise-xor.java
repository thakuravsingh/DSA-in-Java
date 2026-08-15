class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int countZero = 0;
        int xor = 0;
        for(int ele : nums){
            if(ele == 0) countZero++;
            xor ^= ele;
        }
        if(countZero == n) return 0;
        if(xor != 0) return n;
        else return n - 1;
    }
}