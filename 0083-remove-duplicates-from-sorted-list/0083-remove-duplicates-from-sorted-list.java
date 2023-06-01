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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t= head;
        
        while(t!=null){
             while(t.next!=null && t.val == t.next.val ){
                t.next=t.next.next;
               
        }
            t=t.next;
        }

        return head;
    }
}