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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr=new ArrayList<>();
        inOrder(root,arr);
        int low=0,high=arr.size()-1;
        while(low<high){
            int sum=arr.get(low)+arr.get(high);
            if(sum==k)
            return true;
            else if(sum<k)
            low++;
            else
            high--;
        }
        return false;
    }

    public void inOrder(TreeNode root, List<Integer> arr){
        if(root==null)
        return;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
    }
}
