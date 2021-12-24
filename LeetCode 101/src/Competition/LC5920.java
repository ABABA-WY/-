package Competition;

import java.util.Arrays;

public class LC5920 {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().getAsInt();
        System.out.println(r);
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0;
            for (int x : quantities) {
                cnt += (x - 1) / mid + 1;//向上取整
            }
            if (cnt <= n)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
