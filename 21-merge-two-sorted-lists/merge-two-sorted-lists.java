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
    public ListNode mergeTwoLists(ListNode i, ListNode j) {
        if(i == null && j == null) return null;
        if(i == null) return j;
        if(j == null) return i;
        ListNode ans = null;
        if(i.val < j.val){
            ans = new ListNode(i.val);
            ans.next = mergeTwoLists(i.next,j);
        } else {
            ans = new ListNode(j.val);
            ans.next = mergeTwoLists(i,j.next);
        }
        return ans;
    }
}