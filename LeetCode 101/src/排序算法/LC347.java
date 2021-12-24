package 排序算法;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class LC347 {
    public static void main(String[] args) {
        LC347 test=new LC347();
        int[] nums={1,1,1,2,2,2,3,3,3};
        int k=2;
        int[] res= test.topKFrequent(nums,k);
        for(int x:res){
            System.out.println(x);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        List<Integer> res = new ArrayList();
        List<Integer>[] t=new List[nums.length+1];
        for(int key: ans.keySet()){
            int x=ans.get(key);
            if(t[x]==null){
                t[x]=new ArrayList<Integer>();
            }
            t[x].add(key);
        }
        for(int i= nums.length;i>=0&&res.size() < k; i--){
            if(t[i]==null) continue;
            res.addAll(t[i]);
        }
        int[] a=res.stream().mapToInt(Integer::intValue).toArray();
        return a;
    }
}
