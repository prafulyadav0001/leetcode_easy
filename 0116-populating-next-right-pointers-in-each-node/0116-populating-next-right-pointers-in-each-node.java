/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root==null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size()>1){
            Node current = queue.poll();
            
            if(current==null){
                queue.add(null);
            }
            
            else{
                current.next = queue.peek();
                
                if(current.left!=null){
                    queue.add(current.left);
                }
                
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
        }

        return root;
    }
}