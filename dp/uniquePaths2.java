class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(m-1,n-1,obstacleGrid,dp);
    }

    public int fn(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int left=0,up=0;

        if(i!=0 && obstacleGrid[i-1][j]!=1) left=fn(i-1,j,obstacleGrid,dp);
        if(j!=0 && obstacleGrid[i][j-1]!=1) up=fn(i,j-1,obstacleGrid,dp);

        return dp[i][j]=left+up;
    }
}