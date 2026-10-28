class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int fruit = fruits[i];
            boolean flag = false;
            for(int j = 0; j < n; j++){
                if(baskets[j] >= fruit){
                    baskets[j] = -1; // visited
                    flag = true;
                    break;
                }
            }
            if(!flag) ans++;
        }
        return ans;
    }
}