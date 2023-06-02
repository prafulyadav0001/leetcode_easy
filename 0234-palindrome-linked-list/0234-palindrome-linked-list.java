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
    public boolean isPalindrome(ListNode head) {
        int n=0;
        ListNode p=head;
        while(p!=null){
            n++;
            p=p.next;
        }
        
        int arr[]=new int[n];
        p=head;
        
        int i=0;
        while( p!=null){
            arr[i]=p.val;
            i++;
            p=p.next;
        }
        
        int s=0,e=n-1;
        while(s<e){
             if(arr[s]!=arr[e])
            return false;
        s++;
        e--;
      
        }
         return true;
    }
    
}