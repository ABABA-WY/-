package Daly;

import java.util.*;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0;i< nums2.length;i++){
            while(!queue.isEmpty()&&nums2[queue.peek()]<nums2[i]){
                int j=queue.pop();
                map.put(nums2[j],nums2[i]);
            }
            queue.push(i);
        }
        for(int i=0;i< nums1.length;i++){
            ans[i]= map.getOrDefault(nums1[i],-1);
        }
        return ans;
     }
}
