class Solution {
    class Tuple{
        int type;
        int color;
        int count;
        Tuple(int type, int color, int count){
            this.type = type;
            this.color = color;
            this.count = count;
        }
    }
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        Stack<Tuple> st = new Stack<>();
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(types[i-1] != types[i] || colors[i-1] != colors[i]){
                if(cnt % groupSize[types[i-1]] != 0){
                    st.push(new Tuple(types[i-1],colors[i-1],cnt));
                    cnt = 1;
                }
                else{
                    if(!st.isEmpty() && st.peek().type == types[i] && st.peek().color == colors[i]){
                        cnt = 1 + st.peek().count;
                        st.pop();
                    }
                    else cnt = 1;
                }
            }
            else cnt++;
        }
        return st.isEmpty() && cnt % groupSize[types[n-1]] == 0;
    }
}