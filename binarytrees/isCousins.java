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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x || root.val==y)
        return false;
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode xp=null,yp=null;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.val==x){
                    xp=parent.get(node);
                }
                if(node.val==y){
                    yp=parent.get(node);
                }
                if(node.left!=null){
                    parent.put(node.left,node);
                    q.add(node.left);
                }
                if(node.right!=null){
                    parent.put(node.right,node);
                    q.add(node.right);
                }
            }
            if(xp!=null && yp!=null && xp!=yp)
            return true;
        }
        return false;
    }
}