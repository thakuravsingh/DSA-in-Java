class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int j = 0;
        int max = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                if(!flag) flag = true;
                else{
                    while(true){
                        if(nums[j] == 0) break;
                        j++;
                    }
                    j++;
                }
            }
            if(!flag) max = Math.max(max,i-j+1);
            else max = Math.max(max,i-j);
        }
        return (flag) ? max : max - 1;
    }
}