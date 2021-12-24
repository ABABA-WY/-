package 动态规划;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums)
            sum += x;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];//表示前i个数字构成的区间内和为j
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = target; j>=nums[i]; j--) {
                dp[j]|=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
