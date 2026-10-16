class BusBooking {
    boolean[][] vis;
    boolean[][] isWindowFirst;
    int totalTime;
    int minTime;
    public BusBooking(int n) {
        vis = new boolean[n+1][4];
        isWindowFirst = new boolean[n+1][4];
        totalTime = 0;
        minTime = 0; 
    }
    
    public void toggle(String seat) {
        char ch = seat.charAt(0);
        int col = ch-'A';
        int row = Integer.parseInt(seat.substring(1));
        if(col == 1 || col == 2){
            if(!vis[row][col]){
                vis[row][col] = true;
                totalTime += 1;
                minTime += 1;
            }
            else{
                vis[row][col] = false;
                totalTime -= 1;
                minTime -= 1;
            }
        }
        else{
            if(!vis[row][col]){
                vis[row][col] = true;
                minTime += 1;
                int adjCol = col == 0 ? 1 : 2;
                if(!vis[row][adjCol]){
                    totalTime += 1;
                    isWindowFirst[row][col] = true;
                }
                else totalTime += 3;
            }
            else{
                vis[row][col] = false;
                minTime -= 1;
                if(isWindowFirst[row][col]){
                    totalTime -= 1;
                    isWindowFirst[row][col] = false;
                }
                else totalTime -= 3;
            }
        }
    }
    
    public int getTotalTime() {
        return totalTime;
    }
    
    public int getMinTime() {
        return minTime;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */