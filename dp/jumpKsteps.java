public class jumpKsteps {
    public int minimizeCost(int k, int arr[]) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return fn(arr.length-1,k,arr,dp);
    }
    
    public int fn(int idx, int k, int arr[], int[] dp){
        if(idx==0) return 0;
        if(dp[idx]!=-1)
        return dp[idx];
        
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(idx-i>=0){
                int jump=Math.abs(arr[idx]-arr[idx-i]) + fn(idx-i,k,arr,dp);
                min=Math.min(min,jump);
            }
        }
        
        return dp[idx]=min;
    }
}