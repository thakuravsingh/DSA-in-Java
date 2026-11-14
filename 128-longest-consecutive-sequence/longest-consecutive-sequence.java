class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int maxLength = 0;
        for(int ele : set){
            if(!set.contains(ele-1)){
                int cur = 1;
                int val = ele + 1;
                while(set.contains(val)){
                    cur++;
                    val++;
                }
                maxLength = Math.max(maxLength,cur);
            }
        }
        return maxLength;
    }
}