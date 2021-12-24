package 数据结构;

import java.util.*;

public class JZ060 {

    /*public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) ->
                o2.getValue() - o1.getValue());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> e = list.get(i);
            ans[i] = e.getKey();
        }
        return ans;
    }*/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
