package 二分查找;

import java.util.Arrays;
//有效三角形的个数
/*
三角形的性质：两边之和大于第三边
现将数组进行排序，通过逐个查找，再利用
二分找出对应的mid，如果nums[mid]>nums[i]+nums[j]
则说明mid后的数据均不符合条件，这时要将mid向前移动
否则将mid向后移动，寻找出此情况下最优的mid，且mid到j之间的所有数据均符合条件按
* */
public class LC611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int l = j + 1, r = n - 1, k = j;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}
