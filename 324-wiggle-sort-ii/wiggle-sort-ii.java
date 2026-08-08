class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) temp[i] = nums[i];
        Arrays.sort(temp);
        int i = 0;
        int j = n / 2;
        if(n % 2 != 0) j++;
        for(int k = n - 1; k >= 0; k--){
            if(k % 2 != 0) nums[k] = temp[j++];
            else nums[k] = temp[i++];
        }
    }
}