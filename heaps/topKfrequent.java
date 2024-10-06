class topKfrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int freq_a=mp.get(a);
            int freq_b=mp.get(b);
            if(freq_a != freq_b){
                return freq_b-freq_a;
            }
            else{
                return a-b;
            }
        });
        for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],0);
            }
            mp.put(nums[i],mp.get(nums[i])+1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            pq.add(entry.getKey());
        }
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.poll();
        }
        return arr;
    }
}