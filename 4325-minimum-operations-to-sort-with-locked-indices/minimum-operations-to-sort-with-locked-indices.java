class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;
        int op = 0;
        int unlock = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(nums[j+1] < nums[j]){
                    if(locked[j] == 1){
                        unlock++;
                        if(unlock > k) return -1;
                        locked[j] = 0;
                        op++;
                    }
                    if(locked[j+1] == 1){
                        unlock++;
                        if(unlock > k) return -1;
                        locked[j+1] = 0;
                        op++;
                    }
                    swap(nums,j,j+1);
                    op++;
                }
            }
        }
        return op;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}