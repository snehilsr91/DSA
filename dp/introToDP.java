class introToDP {
    //Memoization
    static long topDown(int n) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return recursiveHelper(n,dp);
    }
    //Recursive function for memoization
    static long recursiveHelper(int n, long[] dp){
        if(n<=1)
        return n;
        if(dp[n]!=-1)
        return dp[n];
        return recursiveHelper(n-1, dp)+recursiveHelper(n-2, dp);
    }

    //Tabulation
    static long bottomUp(int n) {
        if(n<=1)
        return n;
        long prev2=0;
        long prev=1;
        for(int i=2;i<=n;i++){
            long curr=prev2+prev;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
