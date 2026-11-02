class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        if(value == 1) return -1;
        long f1 = -1;
        for(int i = 2; i * i <= value; i++){
            if(value % i == 0){
                f1 = i;
                break;
            }
        }
        if(f1 == -1) f1 = value;
        long f2 = value / f1;
        long cnt = Math.max(f2-1,(f2-1)/2*f1);
        if(cnt < index) return -1;
        if(index == n - 1) return value;
        long ans = Math.min(f1*(f2+n-index-1), 2*(f1*(f2+1)/2+n-index-2));
        return ans;
    }
}