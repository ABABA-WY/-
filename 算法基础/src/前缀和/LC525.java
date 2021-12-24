package 前缀和;

import java.util.HashMap;
import java.util.Map;

public class LC525 {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> ans=new HashMap<>();
        int maxLen=0;
        int count =0;
        ans.put(count,-1);
        for (int i = 0; i < n; i++) {
            nums[i]=nums[i]==0?--count:++count;
            if(ans.containsKey(nums[i])){
                maxLen=Math.max(maxLen,i-ans.get(nums[i]));
            }
            else{
                ans.put(nums[i], i);
            }
        }
        return maxLen;
    }
}
