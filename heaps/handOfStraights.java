class handOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
        return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<hand.length;i++){
            pq.offer(hand[i]);
        }
        while(!pq.isEmpty()){
            int prev=pq.poll();
            for(int i=1;i<groupSize;i++){
                if(pq.peek()==null)
                return false;
                else if(pq.peek()==prev+1){
                    prev=pq.poll();
                }
                else if(pq.peek()==prev){
                    q.add(pq.poll());
                    i--;
                }
                else{
                    return false;
                }
            }
            while(!q.isEmpty()){
                pq.add(q.poll());
            }
        }
        return true;
    }
}