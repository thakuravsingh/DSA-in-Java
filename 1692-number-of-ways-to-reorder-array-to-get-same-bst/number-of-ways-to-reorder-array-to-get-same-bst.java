class Solution {
    List<List<Integer>> list;
    int len;
    int mod = (int)1e9+7;
    public int numOfWays(int[] nums) {
        len = nums.length;
        list = new ArrayList<>();
        generateList(list,len);
        List<Integer> arr = new ArrayList<>();
        for(int ele : nums) arr.add(ele);
        return (int)getAns(arr)-1;
    }
    public long getAns(List<Integer> arr){
        int n = arr.size();
        if(n < 3) return 1;
        int root = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(arr.get(i) < root) left.add(arr.get(i));
            else right.add(arr.get(i));
        }
        long x = getAns(left);
        long y = getAns(right);
        long z = list.get(n-1).get(left.size());
        return (((x * y) % mod) * z) % mod;
    }
    public void generateList(List<List<Integer>> list, int n){
        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i && i >= 2; j++){
                int up = list.get(i-1).get(j);
                int dia = list.get(i-1).get(j-1);
                temp.add((int)(((long) up + dia) % mod));
            }
            if(i != 0) temp.add(1);
            list.add(temp);
        }
    }
}