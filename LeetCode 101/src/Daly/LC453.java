package Daly;

public class LC453 {
    public int minMoves(int[] nums) {
        int min=nums[0];
        int ans=0;
        for(int i = 1; i < nums.length; i++){
            min=Math.min(min,nums[i]);
        }
        for(int num:nums){
            ans+=num-min;
        }
        return ans;
    }
}
