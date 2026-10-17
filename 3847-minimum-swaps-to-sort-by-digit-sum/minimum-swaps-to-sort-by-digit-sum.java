class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Object[] ele = new Object[n];
        for(int i = 0; i < n; i++) ele[i] = nums[i];
        Arrays.sort(ele,(a,b)->{
            int num1 = (int)a;
            int num2 = (int)b;
            int sum1 = 0;
            int sum2 = 0;
            while(num1 != 0){
                sum1 += (num1%10);
                num1 /= 10;
            }
            while(num2 != 0){
                sum2 += (num2%10);
                num2 /= 10;
            }
            if(sum1 == sum2) return (int)a-(int)b;
            return sum1-sum2;
        });
        for(Object val : ele) System.out.print(val+" ");
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(nums[i],i);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != (int)ele[i]){
                int j = map.get((int)ele[i]);
                map.put(nums[i],j);
                map.put((int)ele[i],i);
                swap(nums,i,j);
                ans++;
            }
        }
        return ans;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}