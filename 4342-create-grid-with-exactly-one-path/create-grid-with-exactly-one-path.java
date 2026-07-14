class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m - 1; i++){
            sb = new StringBuilder();
            sb.append('.');
            for(int j = 1; j < n; j++) sb.append('#');
            ans[i] = sb.toString();
        }
        sb = new StringBuilder();
        for(int j = 0; j < n; j++) sb.append('.');
        ans[m-1] = sb.toString();
        return ans;
    }
}