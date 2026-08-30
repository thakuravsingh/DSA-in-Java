class Solution {
    int min = Integer.MAX_VALUE;
    public int fxn(int[] nums, int[] arr, int k, int idx){
        if(idx == nums.length){
            int max = Integer.MIN_VALUE;
            for(int ele : arr) max = Math.max(max,ele);
            min =  Math.min(min,max);
            return max;
        }
        for(int i = 0; i < k; i++){
            arr[i] += nums[idx];
            fxn(nums,arr,k,idx+1);
            arr[i] -= nums[idx];
        }
        return min;
    }
    public int distributeCookies(int[] nums, int k) {
        int[] arr = new int[k];
        return fxn(nums,arr,k,0);
    }
}