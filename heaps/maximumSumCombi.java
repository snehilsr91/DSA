public class maximumSumCombi {
    public int[] solve(int[] A, int[] B, int C) {
        if(A==null || B==null || C<=0){
            return new int[]{};
        }
        Arrays.sort(A);
        Arrays.sort(B);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[0]-a[0]);
        pq.add(new int[]{A[A.length-1]+B[B.length-1],A.length-1,B.length-1});
        
        int[] res=new int[C];
        int ind=0;
        
        HashSet<String> vis=new HashSet<>();
        vis.add((A.length-1)+","+(B.length-1));
        while(!pq.isEmpty() && ind<C){
            int[] curr=pq.poll();
            int i=curr[1];
            int j=curr[2];
            
            res[ind]=curr[0];
            ind++;
            
            if(i>0 && vis.add((i-1)+","+j))
            pq.add(new int[]{A[i-1]+B[j],i-1,j});
            
            if(j>0 && vis.add(i+","+(j-1)))
            pq.add(new int[]{A[i]+B[j-1],i,j-1});
        }
        return res;
    }
}