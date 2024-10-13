class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int curMax=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums.get(i).get(0),i,0});
            curMax=Math.max(curMax,nums.get(i).get(0));
        }
        int[] ans=new int[]{0,Integer.MAX_VALUE};
        while(true){
            int[] curr=pq.poll();
            int curMin=curr[0], listIdx=curr[1], eleIdx=curr[2];
            if(curMax-curMin<ans[1]-ans[0]){
                ans[0]=curMin;
                ans[1]=curMax;
            }
            if(eleIdx+1>=nums.get(listIdx).size()) break;

            int newAddn=nums.get(listIdx).get(eleIdx+1);
            curMax=Math.max(curMax,newAddn);

            pq.add(new int[]{newAddn,listIdx,eleIdx+1});
        }
        return ans;
    }
}