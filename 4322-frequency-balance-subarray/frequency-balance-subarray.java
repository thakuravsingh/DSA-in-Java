class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            HashMap<Integer,Integer> freqMap = new HashMap<>();
            int j = i;
            while(j < n){
                int oldFreq = map.getOrDefault(nums[j], 0);
                if(oldFreq > 0){
                    freqMap.put(oldFreq, freqMap.get(oldFreq) - 1);
                    if(freqMap.get(oldFreq) == 0) freqMap.remove(oldFreq);
                }
                int newFreq = oldFreq + 1;
                map.put(nums[j], newFreq);
                freqMap.put(newFreq, freqMap.getOrDefault(newFreq, 0) + 1);
                if(map.size() == 1){
                    ans = Math.max(ans,newFreq);
                }
                else if(freqMap.size()==2){
                    ArrayList<Integer> arr = new ArrayList<>();
                    for(int key : freqMap.keySet()) arr.add(key);
                    Collections.sort(arr);
                    if(arr.get(1) / arr.get(0) == 2 && arr.get(1) % arr.get(0) == 0) ans = Math.max(ans,j-i+1);
                }
                j++;
            }
        }
        return ans;
    }
}