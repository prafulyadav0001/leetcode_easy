/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
         if(root == null)
         return wrapList;
        
       qu.offer(root);
        
        while(!qu.isEmpty()){
            int n=qu.size();
            List<Integer> sl= new LinkedList<Integer>();
            
            for(int i=0 ;i<n;i++){
                if(qu.peek().left!=null)
                    qu.offer(qu.peek().left);
                if(qu.peek().right!=null)
                    qu.offer(qu.peek().right);
                
                sl.add(qu.poll().val);
            }
            
            wrapList.add(sl);
        }
       
        return wrapList;
    }
}