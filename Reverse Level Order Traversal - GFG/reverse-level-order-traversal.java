//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.reverseLevelOrder(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}


 

// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/





class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>ans=new ArrayList<>();
       Queue<Node> queue = new LinkedList<>();
       queue.add(node);
 
       while (!queue.isEmpty()) {
         Node nodeData = queue.poll();
         st.add(nodeData.data);
 
         if (nodeData.right != null) {
             queue.add(nodeData.right);
         }
 
   
         if (nodeData.left != null) {
            queue.add(nodeData.left);
         }
       }
 
       while(!st.isEmpty()) {
          //System.out.print(st.pop()+" ");
          ans.add(st.pop());
       }
       return ans;
  }
    }











// class Tree
// {
//      public ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
//     {
      
//         ArrayList<Integer> revArrayList = new ArrayList<Integer>();
//         for (int i = alist.size() - 1; i >= 0; i--) {
 
            
//             revArrayList.add(alist.get(i));
//         }
 
        
//         return revArrayList;
//     }
    
    
//     public ArrayList<Integer> reverseLevelOrder(Node node) 
//     {
//         // code here
//         Queue<Node> q=new LinkedList<Node>();
//         ArrayList<Integer> list=new  ArrayList<Integer>();
//         if(node==null)
//         return list;
        
//         q.add(node);
//         while(!q.isEmpty()){
//             int n=q.size();
//             for(int i=0;i<n;i++){
//                 if(q.peek().left!=null){
//                     q.add(q.peek().left);
//                 }
//                 if(q.peek().right!=null){
//                     q.add(q.peek().right);
//                 }
                
//                 list.add(q.poll().data);
//             }
            
//         }
//         return reverseArrayList(list);
//     }
// }      