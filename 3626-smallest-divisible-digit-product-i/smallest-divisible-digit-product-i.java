class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;
        while(true){
            int num = n;
            int product = 1;
            while(num != 0){
                product *= (num % 10);
                num /= 10;
            }
            if(product % t == 0){
                ans = n;
                break;
            }
            else n++;
        }
        return ans;
    }
}