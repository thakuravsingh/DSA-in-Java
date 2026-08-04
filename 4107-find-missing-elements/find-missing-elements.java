class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int extra = nums[0];
        while(i < n - 1){
            int j = i + 1;
            if((nums[j] - j) != extra) {
               int temp = 1;
                while(nums[i]+temp != nums[j]){
                    ans.add(nums[i] + temp);
                    temp++;
                }
            }
            i = j;
        }
        return ans;
    }
}