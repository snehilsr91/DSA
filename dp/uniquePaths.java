import java.util.*;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(m-1,n-1,dp);
    }

    public int fn(int i, int j, int[][] dp){
        if(i==0 && j==0)
        return 1;
        if(dp[i][j]!=-1)
        return dp[i][j];
        return dp[i][j]=(i==0?0:fn(i-1,j,dp))+(j==0?0:fn(i,j-1,dp));
    }
}