class Solution {
    public boolean increasingTriplet(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele : nums){
            if(set.isEmpty() || set.last() < ele) set.add(ele);
            else{
                Integer lb = set.ceiling(ele);
                if(lb != null){
                    set.remove(lb);
                    set.add(ele);
                }
            }
        }
        return set.size() >= 3;
    }
}