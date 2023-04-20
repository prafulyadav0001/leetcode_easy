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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(root,0,0));
        int curLevel = 0;
        int start = 0,prev = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.level != curLevel){
                max = Math.max(max,prev - start+1);
                curLevel = node.level;
                start = node.number;
            }
            prev = node.number;
            if(node.node.left != null){
                q.offer(new Node(node.node.left,node.level+1,node.number * 2 +1));
            }
            if(node.node.right != null){
                q.offer(new Node(node.node.right,node.level+1,node.number * 2 +2));
            }
        }
        max = Math.max(max,prev - start+1);
        return max;
    }
    class Node{
        TreeNode node;
        int level;
        int number;
        Node(TreeNode node,int level,int number){
            this.node = node;
            this.level = level;
            this.number = number;
        }
    }
}