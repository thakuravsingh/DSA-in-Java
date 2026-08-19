class Solution {
    public int maxNumberOfFamilies(int m, int[][] grid) {
        int n = grid.length;
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int[] ele : grid){
            if(!map.containsKey(ele[0])) map.put(ele[0],new HashSet<>());
            map.get(ele[0]).add(ele[1]);
            map.put(ele[0],map.get(ele[0]));
        }
        int ans = 0;
        ans += (2 * (m - map.size()));
        for(HashSet<Integer> set : map.values()){
            boolean a = (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5));
            boolean b = (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7));
            boolean c = (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9));
            if(a && c) ans += 2;
            else if(a || b || c) ans++;
        }
        return ans;
    }
}