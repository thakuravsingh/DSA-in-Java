class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : nums){
            if(list.isEmpty() || list.getLast() < ele) list.add(ele);
            else{
                int lo = 0;
                int hi = list.size() - 1;
                int ans = lowerBound(list,lo,hi,ele);
                list.set(ans,ele);
            }
        }
        return list.size();
    }
    public int lowerBound(ArrayList<Integer> list, int lo, int hi, int ele){
        int ans = 0;
        while(lo <= hi){
            int mid = lo + (hi-lo) / 2;
            if(list.get(mid) >= ele){
                ans = mid;
                hi = mid - 1;
            } else{
                lo = mid+1;
            }
        }
        return ans;
    }
}