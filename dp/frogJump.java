import java.util.* ;
import java.io.*; 

public class frogJump{
    public static int frogjump(int n, int heights[]) {
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        return helper(n,heights,arr);
    }
    
    public static int helper(int n, int heights[], int arr[]){
        if(n==1)
        return 0;
        else if(n==2)
        return Math.abs(heights[1]-heights[0]);
        else if(arr[n-1]!=-1)
        return arr[n-1];
        int sum1=Math.abs(heights[n-1]-heights[n-2])+helper(n-1,heights,arr);
        int sum2=Math.abs(heights[n-1]-heights[n-3])+helper(n-2,heights,arr);
        arr[n-1]=Math.min(sum1,sum2);
        return arr[n-1];
    }
}