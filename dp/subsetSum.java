class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp=new int[arr.length][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fn(N-1,sum,arr,dp)==1;
    }
    
    static int fn(int idx, int k, int arr[], int dp[][]){
        if(k==0) return 1;
        if(k<0) return 0;
        if(idx==0) return (arr[0]==k)?1:0;
        if(dp[idx][k]!=-1) return dp[idx][k];
        return dp[idx][k]=fn(idx-1,k-arr[idx],arr,dp)|fn(idx-1,k,arr,dp);
    }
}