class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int sec = 0;
        for(int ele : nums){
            if(ele >= max) {
                sec = max;
                max = ele;
            }
            else if(sec < ele) sec = ele;
        }
        return (max-1) * (sec-1);
    } 
}