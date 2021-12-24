package lable11;

import java.util.Arrays;

public class LC1710 {
    public static void main(String[] args) {
        int [] nums={1,2,5,9,5,9,5,5,5};
        System.out.println(new LC1710().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int pre=-1,count=0;
        for (int x:nums) {
            if(count == 0){
                pre=x;
                count++;
            }
            else if(x==pre){
                count++;
            }
            else {
                count--;
            }
        }
        if(count>0){
            int n=0;
            for (int x : nums) {
                if(x==pre) n++;
            }
            if(n>nums.length/2)  return pre;
        }
        return -1;
    }

}
