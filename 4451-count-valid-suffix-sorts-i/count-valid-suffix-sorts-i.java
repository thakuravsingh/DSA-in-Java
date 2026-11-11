class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int[] freq = new int[(int)1e5+1];
        boolean[] isPrefixSame = new boolean[n];
        boolean flag = true;
        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
            freq[target[i]]--;
            if(nums[i] != target[i]) flag = false;
            if(flag){
                isPrefixSame[i] = true;
            }
        }
        for(int i = 0; i <= (int)1e5; i++) if(freq[i] != 0) return 0;
        boolean[] suffix = new boolean[n];
        flag = true;
        suffix[n-1] = true;
        for(int i = n - 2; i >= 0; i--){
            if(target[i] < target[i+1]) flag = false;
            if(flag) suffix[i] = true;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(i > 0){
                if(isPrefixSame[i-1] && suffix[i]) ans++;
            }
            else{
                if(suffix[i]) ans++;
            }
        }
        return ans;
    }
}