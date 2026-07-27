class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int n = endTime.length();
        int endSec = Integer.parseInt(endTime.substring(n-2));
        int startSec = Integer.parseInt(startTime.substring(n-2));
        int endMin = Integer.parseInt(endTime.substring(3,5));
        int startMin = Integer.parseInt(startTime.substring(3,5));
        int endHour = Integer.parseInt(endTime.substring(0,2));
        int startHour = Integer.parseInt(startTime.substring(0,2));
        int ans = 0;
        boolean flag = false;
        if(endSec < startSec){
            flag = true;
            ans += (endSec + 60 - startSec);
        }
        else ans += (endSec - startSec);
        if(flag) endMin--;
        boolean flag2 = false;
        if(endMin < startMin){
            flag2 = true;
            ans += (endMin + 60 - startMin) * 60;
        }
        else ans += (endMin - startMin) * 60;
        if(flag2) endHour--;
        ans += (endHour - startHour) * 3600;
        return ans;
    }
}