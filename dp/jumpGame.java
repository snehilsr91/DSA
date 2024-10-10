class jumpGame {
    public boolean canJump(int[] nums) {
        int[] arr=new int[nums.length];
        Arrays.fill(arr,-1);
        return helper(0,nums,arr)==1;
    }

    public int helper(int idx, int[] nums, int[] arr){
        if(idx==nums.length-1)
        return 1;
        if(arr[idx]!=-1)
        return arr[idx];
        for(int i=1;i<=nums[idx];i++){
            int flag=helper(idx+i,nums,arr);
            arr[idx]=flag;
            if(flag==1)
            return 1;
        }
        return 0;
    }
}