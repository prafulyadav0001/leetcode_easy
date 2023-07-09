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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        Stack<List<Integer>> st = new Stack<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> p = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
              
                TreeNode last = q.poll();
                
                if(last.left != null){
                    q.add(last.left);
                }
                
                if(last.right != null){
                    q.add(last.right);
                }
                
                p.add(last.val);
            }
            st.push(p);
        }
        
        
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        
        
        return list;
    }
}