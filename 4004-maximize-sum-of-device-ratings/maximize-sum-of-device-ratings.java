class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        long rating = 0;
        if(n == 1){
            for(int[] ele : units) rating += ele[0];
            return rating;
        }
        for(int[] ele : units) Arrays.sort(ele);
        int firstMin = units[0][0];
        int secMin = units[0][1];
        for(int i = 1; i < m; i++){
            firstMin = Math.min(firstMin,units[i][0]);
            secMin = Math.min(secMin,units[i][1]);
        }
        int count = 0;
        rating += firstMin;
        for(int i = 0; i < m; i++){
            if(units[i][1] != secMin) rating += units[i][1];
            else count++;
        }
        rating += (count - 1) * secMin;
        return rating;
    }
}