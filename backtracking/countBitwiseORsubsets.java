class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr=0;
        for(int i=0;i<nums.length;i++){
            maxOr|=nums[i];
        }
        int[] maxi=new int[1];
        fn(0,maxOr,0,nums,maxi);
        return maxi[0];
    }

    public void fn(int ind, int maxOr, int sum, int[] nums, int[] maxi){
        if(ind>=nums.length){
            if(sum==maxOr){
                maxi[0]++;
            }
            return;
        }
        fn(ind+1,maxOr,sum|nums[ind],nums,maxi);
        fn(ind+1,maxOr,sum,nums,maxi);
    }
}