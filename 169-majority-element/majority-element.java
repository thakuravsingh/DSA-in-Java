class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums) map.put(ele,map.getOrDefault(ele,0)+1);
        int ans = 0;
        int max = 0;
        for(int key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                ans = key; 
            }
        }
        return ans;
    }
}