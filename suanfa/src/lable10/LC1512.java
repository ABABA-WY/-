package lable10;

import java.util.*;

public class LC1512 {
    public static void main(String[] args) {
        int [] nums={1,1,1,1};
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        int ret=0;
        for(int key: ans.keySet()){
            int count=ans.get(key);
            ret+=count*(count-1)/2;
        }
        System.out.println(ret);
    }
}
