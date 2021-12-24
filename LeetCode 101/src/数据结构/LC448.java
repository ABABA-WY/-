package 数据结构;

import java.util.*;

public class LC448 {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        for(int i:new LC448().findDisappearedNumbers(nums)){
            System.out.println(i);
        }
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n= nums.length;
        Map<Integer, Integer> ans = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<=n;i++){
            if(ans.getOrDefault(i,0)==0){
                res.add(i);
            }
        }
        return res;
    }
}
