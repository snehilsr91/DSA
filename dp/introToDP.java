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
        long fnm1= recursiveHelper(n-1, dp);
        long fnm2= recursiveHelper(n-2, dp);
        dp[n-1]=fnm1;
        dp[n-2]=fnm2;
        return fnm1+fnm2;
    }

    //Tabulation
    static long bottomUp(int n) {
        if(n<=1)
        return n;
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++){
            prev2=prev;
            prev=i;
        }
        return prev;
    }
}
