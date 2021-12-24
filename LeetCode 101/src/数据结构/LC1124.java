package 数据结构;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC1124 {
    public static void main(String[] args) {
        int[] h = {6, 9, 9};
        System.out.println(new LC1124().longestWPI(h));
    }

    //单调栈
    public int longestWPI(int[] hours) {

        int res = 0;
        int sum = 0;
        Map<Integer, Integer> ans = new HashMap<Integer, Integer>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (!ans.containsKey(sum)) {
                    ans.put(sum, i);
                }
                if (ans.containsKey(sum - 1)) {
                    res = Math.max(res, i - ans.get(sum - 1));
                }
            }
        }
        return res;
    }


}
