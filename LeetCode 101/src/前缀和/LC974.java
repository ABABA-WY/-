package 前缀和;

import java.util.HashMap;
import java.util.Map;

public class LC974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        //前缀和计算；
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //k本身
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            //取模
            int key = (sum % k + k) % k;
            int contain = map.getOrDefault(key, 0);
            ans += contain;
            map.put(key, contain + 1);
        }
        return ans;
    }
}
