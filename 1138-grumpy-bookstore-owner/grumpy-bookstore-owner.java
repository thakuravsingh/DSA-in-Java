class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0) sum += customers[i];
        }
        for(int i = 0; i < minutes; i++) if(grumpy[i] == 1) sum += customers[i];
        maxSum = Math.max(maxSum,sum);
        int i = 1;
        int j = minutes;
        while (j < n){
            int sub = (grumpy[i-1] == 0) ? 0 : customers[i-1];
            int add = (grumpy[j] == 1) ? customers[j] : 0;
            sum = sum - sub + add;
            maxSum = Math.max(maxSum,sum);
            i++;
            j++;
        }
        return maxSum;
    }
}