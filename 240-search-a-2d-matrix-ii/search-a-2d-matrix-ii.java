class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = -1;
        int lo = 0;
        int hi = n - 1;
        while(lo <= hi){
            int mid = lo + (hi-lo) / 2;
            if(matrix[0][mid] <= target){
                ans = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        if(ans == -1) return false;
        for(int j = 0; j <= ans; j++){
            lo = 0;
            hi = m - 1;
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(matrix[mid][j] == target) return true;
                if(matrix[mid][j] > target) hi  = mid - 1;
                else lo = mid + 1;
            }
        }
        return false;
    }
}