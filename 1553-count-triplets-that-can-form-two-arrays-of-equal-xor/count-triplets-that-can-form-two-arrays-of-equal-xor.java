class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int a = 0;
            for(int j = i + 1; j < n; j++){
                a ^= arr[j-1];
                int b = 0;
                for(int k = j; k < n; k++){
                    b ^= arr[k];
                    if(a == b) ans++;
                }
            }
        }
        return ans;
    }
}