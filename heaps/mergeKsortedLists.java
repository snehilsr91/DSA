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
class mergeKsortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode lnode:lists){
            if(lnode!=null)
            pq.offer(lnode);
        }
        ListNode dnode=new ListNode(0);
        ListNode cur=dnode;
        while(!pq.isEmpty()){
            cur.next=pq.poll();
            cur=cur.next;
            if(cur.next!=null){
                pq.offer(cur.next);
            }
        }
        return dnode.next;
    }
}
