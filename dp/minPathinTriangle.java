class minPathinTriangle {
    public int minimumTotal(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fn(0,0,triangle,dp);
    }

    public int fn(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i==triangle.size()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int left=triangle.get(i).get(j)+fn(i+1,j,triangle,dp);
        int right=triangle.get(i).get(j)+fn(i+1,j+1,triangle,dp);

        return dp[i][j]=Math.min(left,right);
    }
}