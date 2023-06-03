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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, tail = null, temp = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        prev = dummy;
        for(int i = 0; i < left - 1; ++i) prev = prev.next;
        tail = prev.next;
        for(int i = 0; i < right - left; ++i){
            temp = prev.next;
            prev.next = tail.next;
            tail.next = tail.next.next;
            prev.next.next = temp;
        }
        return dummy.next;
    }
}