class Solution {
    public boolean check(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]<nums[nums.length-1])
                cnt++;
                continue;
            }
            if(nums[i]<nums[i-1])
            cnt++;
        }
        return cnt<=1;
    }
}