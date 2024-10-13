class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=grid[i][j];
                    continue;
                }
                int left=Integer.MAX_VALUE,up=Integer.MAX_VALUE;
                if(i>0) left=prev[j];
                if(j>0) up=temp[j-1];

                temp[j]=grid[i][j]+Math.min(left,up);
            }
            prev=temp;
        }
        return prev[n-1];
    }
}