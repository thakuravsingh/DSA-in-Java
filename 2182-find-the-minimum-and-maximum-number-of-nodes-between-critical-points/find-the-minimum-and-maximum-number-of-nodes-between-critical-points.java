/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;
        if(c == null) return new int[]{-1,-1};
        int idx = 1 , firstIdx = -1 , lastIdx = -1 , minDist = Integer.MAX_VALUE;
        while(c != null){
            if((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)){
                if(firstIdx == -1) firstIdx = idx;
                if(lastIdx != -1){
                    int dist = idx  - lastIdx;
                    minDist = Math.min(dist,minDist);
                }
                lastIdx = idx;
            }
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }
        int maxDist = lastIdx - firstIdx;
        if(firstIdx == -1 || firstIdx == lastIdx) return new int[]{-1,-1};
        return new int[]{minDist,maxDist};

    }
}