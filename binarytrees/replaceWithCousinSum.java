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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            arr.add(sum);
        }
        root.val=0;
        q.add(root);
        int lvl=0;
        while(!q.isEmpty()){
            int size=q.size();
            lvl++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int childSum=(node.left==null?0:node.left.val)+(node.right==null?0:node.right.val);
                if(node.left!=null){
                    node.left.val=arr.get(lvl)-childSum;
                    q.add(node.left);
                }
                if(node.right!=null){
                    node.right.val=arr.get(lvl)-childSum;
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}