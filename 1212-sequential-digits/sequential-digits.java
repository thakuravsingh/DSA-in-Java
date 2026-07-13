class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String str = "123456789";
        int n = str.length();
        int min_digit = 0;
        int max_digit = 0;
        int num1 = low;
        int num2 = high;
        while(num1 != 0){
            min_digit++;
            num1 /= 10;
        }
        while(num2 != 0){
            max_digit++;
            num2 /= 10;
        }
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < n && j - i + 1 != min_digit) j++;
            while(j < n && j - i + 1 != max_digit + 1){
                int ans = Integer.parseInt(str.substring(i, j + 1));
                if(ans >= low && ans <= high) list.add(ans);
                j++;
            }
            j = i + min_digit;
        }
        Collections.sort(list);
        return list;
    }
}