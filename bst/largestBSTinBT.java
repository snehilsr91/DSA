class Node  
{ 
     int data; 
     Node left, right; 
   
     public Node(int d)  
     { 
         data = d; 
         left = right = null; 
     } 
}

class NodeValue{
    public int maxnode,minnode,maxsize;
    NodeValue(int maxnode, int minnode, int maxsize){
        this.maxnode=maxnode;
        this.minnode=minnode;
        this.maxsize=maxsize;
    }
}

class largestBSTinBT{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        largestBSTinBT obj=new largestBSTinBT();
        return obj.helper(root).maxsize;
    }
    
    private NodeValue helper(Node root){
        if(root==null){
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        NodeValue left=helper(root.left);
        NodeValue right=helper(root.right);
        if(root.data<=left.maxnode || root.data>=right.minnode){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxsize,right.maxsize));
        }
        return new NodeValue(Math.max(root.data,right.maxnode),Math.min(root.data,left.minnode),1+left.maxsize+right.maxsize);
    }
    
}