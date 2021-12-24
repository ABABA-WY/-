package 数据结构;

import java.util.*;

public class LC128 {
    public static void main(String[] args) {
        int[] nums={200,4,100,1,3,2};
        System.out.println(new LC128().longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> ans=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        int res=0;
        for(int num:ans){
            if(!ans.contains(num-1)){
                int count = 1;
                int cur=num;
                while (ans.contains(cur+1)){
                    count++;
                    cur++;
                }
                res=Math.max(count,res);
            }
        }
        return res;
    }
}
