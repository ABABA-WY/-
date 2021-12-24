package lable5;

public class Lc198 {
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        if(nums.length ==0||nums==null)
            return;
        if(nums.length == 1)
            return;
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length; i++){
            dp[i] = Math.max((dp[i-2]+nums[i]),dp[i-1]);
        }
        return;
    }
}
