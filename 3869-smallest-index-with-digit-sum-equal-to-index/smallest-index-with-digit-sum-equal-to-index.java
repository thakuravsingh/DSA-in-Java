class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int sum = 0;
            while(num != 0){
                int rem = num % 10;
                sum += rem;
                num /= 10;
            }
            if(sum == i){
                idx = i;
                break;
            }
        }
        return idx;
    }
}