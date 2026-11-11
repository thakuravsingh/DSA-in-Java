class Solution {
    public long countValidSubstrings(String s) {
        long n = s.length();
        long[] lastOccur = new long[2];
        Arrays.fill(lastOccur,-1);
        long start = -1;
        long invalid = 0;
        long prev = -1;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'a') lastOccur[0] = i;
            else if(ch == 'b') {
                if(lastOccur[0] == -1) continue;
                lastOccur[1] = i;
                if(lastOccur[1] > lastOccur[0]) start = lastOccur[0];
            }
            else{
                if(lastOccur[0] != -1 && lastOccur[1] != -1){
                    if(start > prev) {
                        invalid += (start - prev) * (n - i);
                        prev = start;
                    }
                }
            }
        }
        return (n * (n + 1) / 2) - invalid;
    }
}