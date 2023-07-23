//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
     static Node segregate(Node head)
    {
        // add your code here
        Node zero  = new Node(0);
        Node one  = new Node(1);
        Node two = new Node(2);
        Node temp = head;
        Node temp0 = zero,temp1 = one,temp2 = two;
        while(temp!=null){
            if(temp.data ==0){
                temp0.next = temp;
                temp0 = temp0.next;
                
            }
            else if(temp.data == 1){
                temp1.next = temp;
                temp1 = temp1.next;
             
            }
            else if(temp.data == 2){
                temp2.next = temp;
                temp2  = temp2.next;
               
            }
            temp = temp.next;
            }
            temp2.next = null;
            
            if(zero.next!= null){
                head = zero.next;
                if(one.next!=null){
                    temp0.next = one.next;
                    temp1.next = two.next;
                }
                else temp0.next = two.next;
            }
            else if(one.next!=null){
                head = one.next;
                temp1.next = two.next;
            }
            else head = two.next;

            return head;
    }
}


