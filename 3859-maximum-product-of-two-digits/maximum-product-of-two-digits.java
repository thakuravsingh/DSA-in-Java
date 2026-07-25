class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int num = n;
        while(num != 0){
            int digit = num %  10;
            arr.add(digit);
            num /= 10;
        }
        Collections.sort(arr);
        return arr.get(arr.size()-1) * arr.get(arr.size()-2);
    }
}