package 数据结构;

import java.util.*;

public class LC594 {
    public static void main(String[] args) {
        int[] nums={1,3,2,2,5,2,3,7};
        System.out.println(new LC594().findLHS(nums));
    }
    public int findLHS(int[] nums) {
        int ret=0;
        Map<Integer, Integer> ans=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans.put(nums[i], ans.getOrDefault(nums[i],0)+1);
        }
        for(int key:ans.keySet()){
            if(ans.containsKey(key+1))
                ret=Math.max(ret,ans.get(key)+ans.get(key+1));
        }
        return ret;
    }
}
