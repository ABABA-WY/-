package lable8;

import java.util.*;

public class Lcm1624 {
    public static void main(String[] args) {
        int [] nums={5,6,5,6};
        int target=11;
        Arrays.sort(nums);
        List<List<Integer>> ret=new ArrayList<>();
        int left=0,right = nums.length-1;
        while (left < right) {
            if (nums[left]+nums[right]<target){
                left++;
            }
            else if(nums[left] + nums[right]> target){
                right--;
            }
            else
                ret.add(Arrays.asList(nums[left++], nums[right--]));
        }
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.size());
            System.out.println(ret.get(i));
        }
    }
}
