package 动态规划;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        int count = 0;
        f[count++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (f[count - 1] < nums[i])
                f[count++] = nums[i];
            else {
                int l = 0, r = count - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (f[mid] > nums[i]) {
                        r = mid;
                    } else
                        l = mid + 1;
                }
                f[r] = nums[i];
            }
        }
        return count;
    }
}
