class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0,31,59,90,120,151,181,212,243,273,304,334,365}; // for indexoutofbound
        int[][] times = new int[2][2];
        int arriveAliceMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int arriveAliceDate = Integer.parseInt(arriveAlice.substring(3));
        int arriveBobMonth = Integer.parseInt(arriveBob.substring(0,2));
        int arriveBobDate = Integer.parseInt(arriveBob.substring(3));
        times[0][0] = days[arriveAliceMonth-1] + arriveAliceDate;
        times[1][0] = days[arriveBobMonth-1] + arriveBobDate;
        int leaveAliceMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int leaveAliceDate = Integer.parseInt(leaveAlice.substring(3));
        int leaveBobMonth = Integer.parseInt(leaveBob.substring(0,2));
        int leaveBobDate = Integer.parseInt(leaveBob.substring(3));
        times[0][1] = days[leaveAliceMonth-1] + leaveAliceDate;
        times[1][1] = days[leaveBobMonth-1] + leaveBobDate;
        Arrays.sort(times,(a,b)->a[0]-b[0]);
        int ans = 0;
        if(times[0][1] >= times[1][0] && times[0][1] <= times[1][1]) ans = times[0][1] - times[1][0] + 1;
        else if(times[0][1] > times[1][1]) ans = times[1][1] - times[1][0] + 1;
        return ans;
    }
}