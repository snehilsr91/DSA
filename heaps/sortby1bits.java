class sortby1bits {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int bitCountA = mp.get(a);
            int bitCountB = mp.get(b);
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            } else {
                return a - b;
            }
        });
        for(int i=0;i<arr.length;i++){
            if(!mp.containsKey(arr[i]))
            mp.put(arr[i],countBits(arr[i]));
            pq.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=pq.poll();
        }
        return arr;
    }

    public int countBits(int n){
        String s=Integer.toBinaryString(n);
        n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            n++;
        }
        return n;
    }
}