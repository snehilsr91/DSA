/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class removeNodes {
    public ListNode removenodes(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode mover=head;
        ListNode prev=null;
        while(mover!=null){
            ListNode temp=mover.next;
            mover.next=prev;
            prev=mover;
            mover=temp;
        }
        head=prev;
        mover=head.next;
        while(mover!=null){
            if(mover.val<prev.val){
                prev.next=mover.next;
                mover=mover.next;
            }
            else{
                prev=mover;
                mover=mover.next;
            }
        }
        mover=head;
        prev=null;
        while(mover!=null){
            ListNode temp=mover.next;
            mover.next=prev;
            prev=mover;
            mover=temp;
        }
        return prev;
    }
}