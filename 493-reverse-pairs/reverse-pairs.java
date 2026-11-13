class Solution {
    int count = 0;
    public void inversion(int[] a, int[] b){
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if((long)a[i] > (long)2 * b[j]){
                count += a.length - i;
                j++;
            }
            else i++;
        }
    }
    public void merge(int[] a, int[] b, int[] c){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(i < a.length){
            c[k++] = a[i++];
        }
        while(j < b.length){
            c[k++] = b[j++];
        }
    }
    public void mergeSort(int[] nums){
        int n = nums.length;
        if(n == 1) return;
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        int idx = 0;
        for(int i = 0 ; i < a.length ; i++){
            a[i] = nums[idx++];
        }
        for(int i = 0; i < b.length ; i++){
            b[i] = nums[idx++];
        }

        mergeSort(a);
        mergeSort(b);

        inversion(a,b);

        merge(a,b,nums);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }
}