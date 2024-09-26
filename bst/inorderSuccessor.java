/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
import java.util.*;
class inorderSuccessor
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x){
	    if(root==null || x==null)
	    return null;
	    List<Node> arr=new ArrayList<>();
	    inOrder(root,arr);
	    Node find=null;
	    for(int i=0;i<arr.size();i++){
	        if(arr.get(i)==x && i!=arr.size()-1)
	        find=arr.get(i+1);
	    }
	    return find;
	}
	
	public void inOrder(Node root, List<Node> arr){
	    if(root==null)
	    return;
	    inOrder(root.left, arr);
	    arr.add(root);
	    inOrder(root.right, arr);
	}
}