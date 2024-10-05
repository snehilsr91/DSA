class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] alpha=new int[26];
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->alpha[b-65]-alpha[a-65]);
        for(char ch:tasks){
            alpha[ch-65]++;
        }
        for(int i=0;i<26;i++){
            if(alpha[i]!=0)
            pq.add((char)(i+65));
        }
        int time=0,cnt=0;
        Queue<int[]> cd=new LinkedList<>();
        while(!pq.isEmpty()||!cd.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                char ch=pq.poll();
                alpha[ch-65]--;
                if(alpha[ch-65]!=0)
                cd.add(new int[]{(int)ch-65,time+n});
            }
            else
            cnt++;
            if(!cd.isEmpty() && cd.peek()[1]==time){
                int[] t=cd.poll();
                char ch=(char)(t[0]+65);
                pq.add(ch);
            }
        }
        return time;
    }
}