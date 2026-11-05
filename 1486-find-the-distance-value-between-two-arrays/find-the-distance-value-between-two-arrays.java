class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int n = arr1.length;
        int m = arr2.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int lo = 0;
            int hi = m - 1;
            int min = Integer.MAX_VALUE;
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(arr2[mid] >= arr1[i]){
                    min = Math.min(min,arr2[mid]-arr1[i]);
                    hi = mid-1;
                }
                else{
                    min = Math.min(min,arr1[i]-arr2[mid]);
                    lo = mid+1;
                }
            }
            if(min > d) ans++;
        }
        return ans;
    }
}