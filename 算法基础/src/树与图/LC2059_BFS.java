package 树与图;

import java.util.ArrayDeque;
import java.util.*;
import java.util.Queue;

public class LC2059_BFS {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        q.offer(start);
        map.put(start,0);
        while (!q.isEmpty()) {
            int x=q.poll();
            if(x==goal)
                return map.get(x);
            for(int i=0;i<nums.length; i++){
                int num=x+nums[i];
                if(!map.containsKey(num)){
                    map.put(num,map.get(x)+1);
                    q.offer(num);
                }
            }
            for(int i=0;i<nums.length; i++){
                int num=x-nums[i];
                if(!map.containsKey(num)){
                    map.put(num,map.get(x)+1);
                    q.offer(num);
                }
            }
            for(int i=0;i<nums.length; i++){
                int num=x^nums[i];
                if(!map.containsKey(num)){
                    map.put(num,map.get(x)+1);
                    q.offer(num);
                }
            }
        }
        return -1;
    }
}
