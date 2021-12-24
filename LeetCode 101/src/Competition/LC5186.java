package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RangeFreqQuery {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < 10010; i++) {
            ans.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            ans.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (ans.get(value).size() == 0) return 0;
        List<Integer> now = ans.get(value);
        int l = 0, r = now.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (now.get(mid) < left) {
                l = mid + 1;
            } else
                r = mid;
        }
        //记录当前的左坐标
        int a = l;
        //不符合条件
        if (a > right || a < left) return 0;
        r = now.size() - 1;
        //找到与right相等或者比right稍大的数
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (now.get(mid) > right) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //当前右坐标
        int b = l;
        //如果当前坐标比right大，则坐标左移
        while(now.get(b) > right) b--;

        return b - a + 1;
    }
}
