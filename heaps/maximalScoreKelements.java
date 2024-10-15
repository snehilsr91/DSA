class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        long score=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int val=pq.poll();
            score+=val;
            pq.add((int)Math.ceil((double)val/3));
        }
        return score;
    }
}