class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        HashMap<int[],Integer> chairs=new HashMap<>();
        PriorityQueue<int[]> dept=new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> arrv=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> emptyChair=new PriorityQueue<>();
        int time=0;
        for(int i=0;i<times.length;i++){
            arrv.add(times[i]);
            emptyChair.add(i);
        }
        int[] target=times[targetFriend];
        while(time<target[0]){
            time++;
            while(!dept.isEmpty() && dept.peek()[1]==time){
                int[] curr=dept.poll();
                int chair=chairs.get(curr);
                emptyChair.add(chair);
                chairs.remove(curr);
            }
            while(!arrv.isEmpty() && arrv.peek()[0]==time){
                int[] curr=arrv.poll();
                chairs.put(curr,emptyChair.poll());
                dept.add(curr);
            }
        }
        return chairs.get(target);
    }
}