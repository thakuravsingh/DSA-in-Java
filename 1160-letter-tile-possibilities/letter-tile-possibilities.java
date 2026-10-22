class Solution {
    HashSet<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        getAns(tiles, used, "");
        return set.size();
    }
    public void getAns(String tiles, boolean[] used, String ans) {
        for(int i = 0; i < tiles.length(); i++) {
            if(used[i]) continue;
            used[i] = true;
            String temp = ans + tiles.charAt(i);
            set.add(temp);
            getAns(tiles, used, temp);
            used[i] = false;
        }
    }
}