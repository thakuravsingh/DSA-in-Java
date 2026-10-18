class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        int ans = n;
        for(int i = n - 2; i >= 0; i--){
            if(position[i+1]-position[i] <= distance || speed[i] > speed[i+1]){
                ans--;
                speed[i] = speed[i+1];
            }
        }
        return ans;
    }
}