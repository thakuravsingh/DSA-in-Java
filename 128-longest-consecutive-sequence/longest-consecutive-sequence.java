class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int n = set.size();
        int[] arr = new int[n];
        int idx = 0;
        for(int ele : set) arr[idx++] = ele;
        Arrays.sort(arr);
        int cur = 1;
        int maxLength = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] - arr[i-1] == 1) cur++;
            else{
                maxLength = Math.max(maxLength,cur);
                cur = 1;
            }
        }
        maxLength = Math.max(maxLength,cur);
        return maxLength;
    }
}