class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen,(int)1e9);
        int ans = (int)1e9;
        int bestMin = (int)1e9;
        int cur = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            cur += arr[i];
            while(cur > target){
                cur -= arr[j];
                j++;
            }
            if(cur == target){
                int len = i-j+1;
                if(j != 0 && minLen[j-1] != (int)1e9){
                    ans = Math.min(ans,len+minLen[j-1]);
                }
                bestMin = Math.min(bestMin,len);
            }
            minLen[i] = bestMin;
         }
        return ans == (int)1e9 ? -1 : ans;
    }
}