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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode i=head;
       ListNode j=head;
        
        while(n!=0){
            i=i.next;
            n--;
        }
        if(i==null){
            return head.next;
        }
        
        while(i.next!=null){
            j=j.next;
            i=i.next;
        }
        
        j.next=j.next.next;
        
        return head;
    }
}