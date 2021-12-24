package 二分查找;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC436 {
    public static void main(String[] args) {
        int[][] intervals = {{4, 5}, {2, 3}, {1, 2}};
        int[] res = new LC436().findRightInterval(intervals);
        for (int x : res) {
            System.out.println(x);
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<int[], Integer>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        int[] ans = new int[intervals.length];
        Arrays.fill(ans, -1);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int l = i, r = intervals.length - 1;
            while (l <= r) {
                int mid = r + l >> 1;
                if (intervals[i][1] <= intervals[mid][0]) {
                    ans[map.get(intervals[i])] = map.get(intervals[mid]);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }
        }
        return ans;
    }
}
