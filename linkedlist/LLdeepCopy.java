/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> mp=new HashMap<>();
        Node mover=head;
        while(mover!=null){
            mp.put(mover,new Node(mover.val));
            mover=mover.next;
        }
        mover=head;
        while(mover!=null){
            Node node=mp.get(mover);
            Node nxt=mp.get(mover.next);
            Node rd=mp.get(mover.random);
            node.random=rd;
            node.next=nxt;
            mover=mover.next;
        }
        return mp.get(head);
    }
}