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
class BSTIterator {
    private Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLefts(root);
    }
    
    public int next() {
        if(st.isEmpty())
        return 0;
        TreeNode node=st.pop();
        pushLefts(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLefts(TreeNode node){
        for(;node!=null;st.push(node),node=node.left){}
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */