package 数据结构;

import java.util.HashMap;
import java.util.IllformedLocaleException;
import java.util.Map;

public class LC137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> ans=new HashMap<>();
        for(int num:nums){
            ans.put(num, ans.getOrDefault(num,0)+1);
        }
        int res=0;
        for(int key: ans.keySet()){
            if(ans.get(key)==1){
                res = key;
            }
        }
        return res;
    }
}
