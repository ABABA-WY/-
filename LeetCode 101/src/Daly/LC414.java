package Daly;

import java.util.Arrays;
import java.util.TreeSet;

public class LC414 {
    public static void main(String[] args) {
        int[] nums={ 2,3, 1};
        System.out.println(new LC414().thirdMax1(nums));
    }
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count=2;
        int x=0;
        for(int i=nums.length - 2; i >= 0; i--){
            x = nums[i];
            int y=nums[i+1];
            if(x!=y)
                count--;
            if(count<=0)
                return x;
        }
        return nums[nums.length - 1];
    }
    public int thirdMax1(int[] nums){
        TreeSet<Integer> ans=new TreeSet<Integer>();
        for(int num:nums){
            ans.add(num);
            if(ans.size() > 3)
                ans.remove(ans.first());
        }
        return ans.size()==3? ans.first() : ans.last();
    }
}
