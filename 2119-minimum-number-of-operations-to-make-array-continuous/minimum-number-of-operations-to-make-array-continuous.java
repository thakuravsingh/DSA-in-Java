class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);
        int[] nums = new int[set.size()];
        int idx = 0;
        for(int ele : set) nums[idx++] = ele;
        Arrays.sort(nums);
        int minOp = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            int max = min + n - 1;
            int l = i;
            int r = nums.length - 1;
            int possible = nums.length;
            while(l <= r){
                int mid = l + (r-l) / 2;
                if(nums[mid] > max){
                    possible = mid;
                    r = mid - 1;
                }
                else l = mid + 1;
            }
            int cur = n - (possible-i);
            minOp = Math.min(minOp,cur);
        }
        return minOp;
    }
}