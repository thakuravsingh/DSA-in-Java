class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(temp[i])) map.put(temp[i],rank++);
        }
        for(int i = 0; i < n; i++) temp[i] = map.get(arr[i]);
        return temp;
    }
}