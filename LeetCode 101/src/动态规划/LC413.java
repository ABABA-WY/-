package 动态规划;

import java.util.Arrays;

public class LC413 {
    public static void main(String[] args) {
        int[]nums= {1,2,3,4};
        System.out.println(new LC413().numberOfArithmeticSlices(nums));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,0);
        for(int i=2;i<nums.length; i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        return ans;
    }
}
