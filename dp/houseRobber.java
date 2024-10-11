public class houseRobber {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return fn(nums.length-1,nums,dp);
    }

    public int fn(int idx, int[] nums, int[] dp){
        if(idx==0) return nums[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int pick=nums[idx] + fn(idx-2,nums,dp);
        int notpick=fn(idx-1,nums,dp);

        return dp[idx]=Math.max(pick,notpick);
    }
}