package Competition;

public class LC5904 {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i]=Math.max(dp[i-1],dp[i-1]|nums[i]);
        }
        return 0;
    }
}
