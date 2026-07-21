class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        int ones = 0;
        for(int i = 0; i < s.length();){
            int j = i;
            while(j < s.length() && s.charAt(j) == '0') j++;
            if(j - i != 0) {
                arr.add(j - i);
                i = j;
            }
            else {
                ones++;
                i++;
            }
        }
        int ans = 0;
        for(int i = 0; i < arr.size()-1; i++){
            ans = Math.max(ans,arr.get(i)+arr.get(i+1));
        }
        return ans+ones;
    }
}