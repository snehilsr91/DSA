class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        int minAns=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ans=fn(0,i,matrix,dp);
            minAns=Math.min(minAns,ans);
        }
        return minAns;
    }

    public int fn(int i, int j, int[][] matrix, int[][] dp){
        if(i==matrix.length) return 0;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int left=Integer.MAX_VALUE,down=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(j>0) left=fn(i+1,j-1,matrix,dp);
        down=fn(i+1,j,matrix,dp);
        if(j<matrix.length-1) right=fn(i+1,j+1,matrix,dp);

        return dp[i][j]=matrix[i][j]+Math.min(left,Math.min(down,right));
    }
}