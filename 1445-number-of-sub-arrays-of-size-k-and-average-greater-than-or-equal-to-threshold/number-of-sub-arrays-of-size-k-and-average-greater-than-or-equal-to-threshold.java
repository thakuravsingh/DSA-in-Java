class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int count = 0;
        int sum = 0;
        double denominator = k;
        for(int i = 0; i < k; i++) sum += arr[i];
        if(sum / denominator >= threshold) count++;
        int i = 1;
        int j = k;
        while(j < n){
            sum = sum - arr[i-1] + arr[j];
            if(sum / denominator >= threshold) count++;
            i++;
            j++;
        }
        return count;
    }
}