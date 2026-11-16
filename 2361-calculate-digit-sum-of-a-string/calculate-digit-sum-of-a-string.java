class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < sb.length(); i += k) {
                int sum = 0;
                for(int j = i; j < i + k && j < sb.length(); j++) sum += sb.charAt(j) - '0';
                str.append(sum);
            }
            sb = str;
        }
        return sb.toString();
    }
}
