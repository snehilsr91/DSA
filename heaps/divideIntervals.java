public class divideIntervals {
    public int minGroups(int[][] intervals) {
        PriorityQueue<int[]> left=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> right=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int time=0;
        for(int i=0;i<intervals.length;i++){
            left.add(intervals[i]);
        }
        int curGrp=0;
        int maxGrp=0;
        while(!left.isEmpty() || !right.isEmpty()){
            time++;
            while(!left.isEmpty() && left.peek()[0]==time){
                curGrp++;
                right.add(left.poll());
            }
            maxGrp=Math.max(maxGrp,curGrp);
            while(!right.isEmpty() && right.peek()[1]==time){
                curGrp--;
                right.poll();
            }
        }
        return maxGrp;
    }
}